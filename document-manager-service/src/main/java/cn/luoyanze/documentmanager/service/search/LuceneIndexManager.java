package cn.luoyanze.documentmanager.service.search;

import cn.luoyanze.documentmanager.service.model.SearchModel;
import cn.luoyanze.documentmanager.service.model.NodeType;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.luoyanze.documentmanager.dao.Tables.*;
import static cn.luoyanze.documentmanager.service.model.SearchModel.wrapperToDocument;
import static cn.luoyanze.documentmanager.service.model.SearchModel.wrapperToSearchModel;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/2 5:37 PM
 */

@Component
public class LuceneIndexManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(LuceneIndexManager.class);

    @Value("${cn.luoyanze.lucene.index.dir}")
    private String path;
    private final DSLContext dao;
    private IndexWriter indexWriter;
    private IndexSearcher indexSearcher;

    public LuceneIndexManager(DSLContext dao) {
        this.dao = dao;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    @PostConstruct
    public void init() throws IOException {
        IndexWriter indexWriter = getIndexWriter();
        indexWriter.deleteAll();
        indexWriter.addDocuments(createInitIndex());
        indexWriter.commit();
    }

    private IndexWriter getIndexWriter() {
        if (indexWriter == null || !indexWriter.isOpen()) {
            return createWriter();
        }
        return indexWriter;
    }

    private IndexSearcher getIndexSearcher() {
        if (indexSearcher == null) {
            return createSearcher();
        }
        return indexSearcher;
    }

    private IndexSearcher createSearcher() {
        try {
            DirectoryReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(path)));
            return new IndexSearcher(reader);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }


    private IndexWriter createWriter() {
        try {
            Analyzer analyzer = new IKAnalyzer();
            FSDirectory directory = FSDirectory.open(Paths.get(path));
            return new IndexWriter(directory, new IndexWriterConfig(analyzer));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    // 生成索引字段
    private List<Document> createInitIndex() {
        List<SearchModel> searchModels
                = dao.select(
                        S1_NODE.UUID.as(SearchModel.NODE_ID),
                        S1_NODE.TEXT.as(SearchModel.TEXT),
                        S1_NODE.DOC_ID.as(SearchModel.FILE_ID),
                        S1_DOC.TITLE.as(SearchModel.TITLE),
                        S1_USER.ACCOUNT.as(SearchModel.AUTHOR)
                ).from(S1_NODE)
                .leftJoin(S1_DOC).on(S1_NODE.DOC_ID.eq(S1_DOC.PRIMARY_ID))
                .leftJoin(S1_USER).on(S1_DOC.USER_ID.eq(S1_USER.PRIMARY_ID))
                .where(S1_NODE.IS_DEL.eq(0))
                .and(S1_NODE.TYPE.eq(NodeType.TEXT))
                .fetchInto(SearchModel.class);

        return searchModels.stream().map(SearchModel::wrapperToDocument).collect(Collectors.toList());
    }

    /**
     * 动态添加索引
     *
     * @param model
     */
    public synchronized void add(SearchModel model) {
        try {
            IndexWriter indexWriter = getIndexWriter();
            indexWriter.addDocument(wrapperToDocument(model));
            indexWriter.commit();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void add(List<SearchModel> models) {
        models.forEach(this::add);
    }

    public synchronized void deleteByNodeId(@NotNull String nodeId) {
        try {
            IndexWriter indexWriter = getIndexWriter();
            indexWriter.deleteDocuments(new Term(SearchModel.NODE_ID, nodeId));
            indexWriter.commit();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteByNodeIds(@NotNull List<String> nodeIds) {
        nodeIds.forEach(this::deleteByNodeId);
    }

    private List<SearchModel> searchFields(String text, String field, int size) {
        try {
            QueryParser queryParser = new QueryParser(field, new IKAnalyzer());
            Query parse = queryParser.parse(text);
            TopDocs textDocs = getIndexSearcher().search(parse, size);

            ArrayList<SearchModel> searchModels = new ArrayList<>();
            for (ScoreDoc doc : textDocs.scoreDocs) {
                searchModels.add(
                        wrapperToSearchModel(getIndexSearcher().doc(doc.doc), doc.score)
                );
            }
            return searchModels;

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<SearchModel> search(String text) {
        try {
            // 去重, 并排序 score为 o1 + o2 / 1.5
            return Stream.of(
                            searchFields(text, SearchModel.TEXT, 10),
                            searchFields(text, SearchModel.TITLE, 10)
                    )
                    .flatMap(Collection::stream)
                    .collect(
                            Collectors.groupingBy(
                                    SearchModel::getNodeId,
                                    Collectors.reducing((o1, o2) -> o2.setScore((o1.getScore() + o2.getScore()) / 1.5F))
                            )
                    )
                    .values().stream()
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .sorted(Comparator.comparingDouble(SearchModel::getScore).reversed())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void updateText(String id, String text) {
        try {
            Document doc = new Document();
            doc.add(new TextField(SearchModel.TEXT, text, Field.Store.YES));
            getIndexWriter().updateDocument(new Term(SearchModel.NODE_ID, id), doc);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
