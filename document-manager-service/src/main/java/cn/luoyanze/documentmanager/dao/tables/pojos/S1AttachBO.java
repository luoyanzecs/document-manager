/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1AttachBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       primaryId;
    private Integer       docPrimaryId;
    private String        link;
    private String        name;
    private Integer       size;
    private LocalDateTime time;
    private Integer       userPrimaryId;
    private Integer       isdel;

    public S1AttachBO() {}

    public S1AttachBO(S1AttachBO value) {
        this.primaryId = value.primaryId;
        this.docPrimaryId = value.docPrimaryId;
        this.link = value.link;
        this.name = value.name;
        this.size = value.size;
        this.time = value.time;
        this.userPrimaryId = value.userPrimaryId;
        this.isdel = value.isdel;
    }

    public S1AttachBO(
        Integer       primaryId,
        Integer       docPrimaryId,
        String        link,
        String        name,
        Integer       size,
        LocalDateTime time,
        Integer       userPrimaryId,
        Integer       isdel
    ) {
        this.primaryId = primaryId;
        this.docPrimaryId = docPrimaryId;
        this.link = link;
        this.name = name;
        this.size = size;
        this.time = time;
        this.userPrimaryId = userPrimaryId;
        this.isdel = isdel;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.primary_id</code>. 自增主键
     */
    public Integer getPrimaryId() {
        return this.primaryId;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.primary_id</code>. 自增主键
     */
    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.doc_primary_id</code>. 文件ID
     */
    public Integer getDocPrimaryId() {
        return this.docPrimaryId;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.doc_primary_id</code>. 文件ID
     */
    public void setDocPrimaryId(Integer docPrimaryId) {
        this.docPrimaryId = docPrimaryId;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.link</code>. 是否链接
     */
    public String getLink() {
        return this.link;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.link</code>. 是否链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.name</code>. 文件名
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.name</code>. 文件名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.size</code>. 文件大小
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.size</code>. 文件大小
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.time</code>. 上传时间
     */
    public LocalDateTime getTime() {
        return this.time;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.time</code>. 上传时间
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.user_primary_id</code>. 用户id
     */
    public Integer getUserPrimaryId() {
        return this.userPrimaryId;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.user_primary_id</code>. 用户id
     */
    public void setUserPrimaryId(Integer userPrimaryId) {
        this.userPrimaryId = userPrimaryId;
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.isDel</code>. 是否删除
     */
    public Integer getIsdel() {
        return this.isdel;
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.isDel</code>. 是否删除
     */
    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("S1AttachBO (");

        sb.append(primaryId);
        sb.append(", ").append(docPrimaryId);
        sb.append(", ").append(link);
        sb.append(", ").append(name);
        sb.append(", ").append(size);
        sb.append(", ").append(time);
        sb.append(", ").append(userPrimaryId);
        sb.append(", ").append(isdel);

        sb.append(")");
        return sb.toString();
    }
}
