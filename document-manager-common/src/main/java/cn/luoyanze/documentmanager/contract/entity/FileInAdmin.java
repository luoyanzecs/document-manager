package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:44 PM
 */


public class FileInAdmin {

    /**
     * 文件的id
     */
    @JsonProperty("id")
    private String fileId;

    /**
     * 文件创建者
     */
    @JsonProperty("owner")
    private String owner;

    /**
     * 文件创建者id
     */
    @JsonProperty("userId")
    private String userId;

    /**
     * 文件标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 文件所属部门
     */
    @JsonProperty("bu")
    private String bu;

    /**
     * 文件创建时间
     */
    @JsonProperty("createTime")
    private String time;

    public FileInAdmin(String fileId, String owner, String userId, String title, String bu, String time) {
        this.fileId = fileId;
        this.owner = owner;
        this.userId = userId;
        this.title = title;
        this.bu = bu;
        this.time = time;
    }


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
