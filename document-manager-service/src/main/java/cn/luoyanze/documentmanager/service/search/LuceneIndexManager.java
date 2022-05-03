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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
    private static final ExecutorService executors = Executors.newFixedThreadPool(4);

    @Value("${cn.luoyanze.lucene.index.dir}")
    private String path;
    private final DSLContext dao;
    private Indexer indexer;


    public LuceneIndexManager(DSLContext dao) {
        this.dao = dao;
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    @PostConstruct
    public void init() throws IOException {
        if (indexer == null) {
            indexer = new Indexer(path);
        }
        IndexWriter indexWriter = indexer.getIndexWriter();
        indexWriter.deleteAll();
        indexWriter.close();
        add(createInitIndex());
    }

    static class Indexer {
        private final String path;
        private IndexWriter indexWriter;
        private IndexSearcher indexSearcher;

        Indexer(String path) {
            this.path = path;
        }

        public IndexWriter getIndexWriter() {
            return createWriter();
        }

        public IndexSearcher getIndexSearcher() {
            return createSearcher();
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

    }

    // 生成索引字段
    private List<SearchModel> createInitIndex() {

        return dao.select(
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
    }

    /**
     * 动态添加索引
     *
     * @param model
     */
    private synchronized void addSync(SearchModel model) {
        try {
            IndexWriter indexWriter = indexer.getIndexWriter();
            indexWriter.addDocument(wrapperToDocument(model));
            indexWriter.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void add(SearchModel model) {
        executors.submit(() -> addSync(model));
    }

    public void add(List<SearchModel> models) {
        models.forEach(this::add);
    }

    private synchronized void deleteByNodeIdSync(@NotNull String nodeId) {
        try {
            IndexWriter indexWriter = indexer.getIndexWriter();
            long l = indexWriter.deleteDocuments(new Term(SearchModel.NODE_ID, nodeId));
            System.out.println(l);
            indexWriter.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteByNodeId(String id) {
        executors.submit(() -> deleteByNodeIdSync(id));
    }

    public void deleteByNodeIds(@NotNull List<String> nodeIds) {
            nodeIds.forEach(this::deleteByNodeId);
    }

    private synchronized void updateTextSync(String id, String text) {
        try {
            Document doc = new Document();
            doc.add(new TextField(SearchModel.TEXT, text, Field.Store.YES));
            IndexWriter indexWriter = indexer.getIndexWriter();
            indexWriter.updateDocument(new Term(SearchModel.NODE_ID, id), doc);
            indexWriter.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void updateText(String id, String text) {
        executors.submit(() -> updateText(id, text));
    }

    private List<SearchModel> searchFields(String text, String field, int size) {
        try {
            QueryParser queryParser = new QueryParser(field, new IKAnalyzer());
            Query parse = queryParser.parse(text);
            TopDocs textDocs = indexer.getIndexSearcher().search(parse, size);

            ArrayList<SearchModel> searchModels = new ArrayList<>();
            for (ScoreDoc doc : textDocs.scoreDocs) {
                searchModels.add(
                        wrapperToSearchModel(indexer.getIndexSearcher().doc(doc.doc), doc.score)
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
                    .collect(Collectors.groupingBy(
                            SearchModel::getFileId,
                            Collectors.reducing((o1, o2) -> o1.getScore() > o2.getScore() ? o1 : o2)
                    )).values().stream()
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .sorted(Comparator.comparingDouble(SearchModel::getScore).reversed())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
