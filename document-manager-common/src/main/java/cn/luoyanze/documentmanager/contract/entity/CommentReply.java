package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:34 PM
 */


public class CommentReply {

    @JsonProperty("commentId")
    private String id;

    @JsonProperty("name")
    private String username;

    @JsonProperty("id")
    private String userId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("time")
    private String time;

    public CommentReply(String id, String username, String userId, String comment, String time) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.comment = comment;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
