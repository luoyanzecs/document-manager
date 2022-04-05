package cn.luoyanze.documentmanager.model;

import java.time.LocalDateTime;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 10:46 PM
 */


public class FileComment {

    private String userId;

    private String username;

    private String avatar;

    private String ctx;

    private int parentId;

    private LocalDateTime time;

    private String commentUUID;

    private int commentPrimaryId;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCommentUUID() {
        return commentUUID;
    }

    public void setCommentUUID(String commentUUID) {
        this.commentUUID = commentUUID;
    }

    public int getCommentPrimaryId() {
        return commentPrimaryId;
    }

    public void setCommentPrimaryId(int commentPrimaryId) {
        this.commentPrimaryId = commentPrimaryId;
    }
}
