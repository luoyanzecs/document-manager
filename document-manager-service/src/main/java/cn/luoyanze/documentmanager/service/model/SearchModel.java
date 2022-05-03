package cn.luoyanze.documentmanager.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.lucene.document.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/2 5:38 PM
 */

@Data
@Accessors(chain = true)
public class SearchModel {
    public final static String FILE_ID = "fileId";
    public final static String TEXT = "text";
    public final static String TITLE = "title";
    public final static String NODE_ID = "nodeId";
    public final static String AUTHOR = "author";

    /**
     * dom 文本节点内容
     */
    @JsonProperty(TEXT)
    private String text;

    /**
     * 所属文件ID
     */
    @JsonProperty(FILE_ID)
    private Integer fileId;

    /**
     * 标题
     */
    @JsonProperty(TITLE)
    private String title;

    /**
     * 文档作者
     */
    @JsonProperty(AUTHOR)
    private String author;

    /**
     * dom节点 ID
     */
    @JsonProperty(NODE_ID)
    private String nodeId;

    private float score;


    public static Document wrapperToDocument(SearchModel model) {
        Document doc = new Document();
        doc.add(new StringField(NODE_ID, model.getNodeId(), Field.Store.YES));
        doc.add(new TextField(TEXT, model.getText(), Field.Store.YES));
        doc.add(new StringField(FILE_ID, model.getFileId().toString(), Field.Store.YES));
        doc.add(new TextField(TITLE, model.getTitle(), Field.Store.YES));
        doc.add(new StringField(AUTHOR, model.getAuthor(), Field.Store.YES));
        return doc;
    }

    public static SearchModel wrapperToSearchModel(Document doc, float score) {
        SearchModel model = wrapperToSearchModel(doc);
        model.setScore(score);
        return model;
    }

    public static SearchModel wrapperToSearchModel(Document doc) {
        SearchModel model = new SearchModel();
        model.setNodeId(doc.get(NODE_ID));
        model.setText(doc.get(TEXT));
        model.setFileId(Integer.parseInt(doc.get(FILE_ID)));
        model.setTitle(doc.get(TITLE));
        model.setAuthor(doc.get(AUTHOR));
        return model;
    }

}
