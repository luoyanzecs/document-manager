package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.Comment;
import cn.luoyanze.documentmanager.contract.entity.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 *
 * /api/user/comment response
 */
public class FileCommentHttpResponse {
    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    /**
     * 评论列表
     */
    @JsonProperty("comments")
    private List<Comment> comments;

    public FileCommentHttpResponse(ResponseHead head, List<Comment> comments) {
        this.head = head;
        this.comments = comments;
    }


    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}