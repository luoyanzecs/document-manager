package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    @JsonProperty("ctx")
    private String ctx;

    @JsonProperty("reply")
    private List<Comment> reply;

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
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

    public List<Comment> getReply() {
        return reply;
    }

    public void setReply(List<Comment> reply) {
        this.reply = reply;
    }
}
