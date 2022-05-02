package cn.luoyanze.documentmanager.search;

import cn.luoyanze.documentmanager.model.SearchModel;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.junit.jupiter.api.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static cn.luoyanze.documentmanager.model.SearchModel.wrapperToSearchModel;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 12:15 AM
 */


public class LuceneIndexManagerTest {

    @Test
    public void test() throws Exception {
        //FSDirectory open = FSDirectory.open(new File("/Users/luoyanze/doc/index/").toPath());
        //
        //IndexWriter indexWriter = new IndexWriter(open, new IndexWriterConfig());
        //Document document = new Document();
        //document.add(new TextField("name", "hahah", Field.Store.YES));
        //indexWriter.addDocument(document);
        //indexWriter.close();
    }

    @Test
    public void search() throws ParseException, IOException {

        //DirectoryReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("/Users/luoyanze/doc/index/")));
        //IndexSearcher indexSearcher = new IndexSearcher(reader);
        //
        //QueryParser queryParser = new QueryParser(SearchModel.TITLE, new IKAnalyzer());
        //Query parse = queryParser.parse("毕业");
        //TopDocs textDocs = indexSearcher.search(parse, 10);
        //System.out.println(textDocs.scoreDocs.length);
        //for (ScoreDoc doc : textDocs.scoreDocs) {
        //    SearchModel model = wrapperToSearchModel(indexSearcher.doc(doc.doc), doc.score);
        //    System.out.println(model);
        //}
    }
}








