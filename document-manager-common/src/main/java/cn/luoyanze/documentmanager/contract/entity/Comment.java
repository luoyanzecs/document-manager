package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:31 PM
 */


public class Comment {

    @JsonProperty("commentId")
    private String id;

    @JsonProperty("name")
    private String username;

    @JsonProperty("id")
    private String userId;

    @JsonProperty("time")
    private String time;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("reply")
    private CommentReply reply;

    public Comment(String id, String username, String userId, String time, String avatar, CommentReply reply) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.time = time;
        this.avatar = avatar;
        this.reply = reply;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public CommentReply getReply() {
        return reply;
    }

    public void setReply(CommentReply reply) {
        this.reply = reply;
    }
}
