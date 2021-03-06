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
public class S1CommentBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       primaryId;
    private Integer       docId;
    private Integer       userId;
    private String        ctx;
    private LocalDateTime createTime;
    private Integer       parentId;

    public S1CommentBO() {}

    public S1CommentBO(S1CommentBO value) {
        this.primaryId = value.primaryId;
        this.docId = value.docId;
        this.userId = value.userId;
        this.ctx = value.ctx;
        this.createTime = value.createTime;
        this.parentId = value.parentId;
    }

    public S1CommentBO(
        Integer       primaryId,
        Integer       docId,
        Integer       userId,
        String        ctx,
        LocalDateTime createTime,
        Integer       parentId
    ) {
        this.primaryId = primaryId;
        this.docId = docId;
        this.userId = userId;
        this.ctx = ctx;
        this.createTime = createTime;
        this.parentId = parentId;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.primary_id</code>. 自增主键
     */
    public Integer getPrimaryId() {
        return this.primaryId;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.primary_id</code>. 自增主键
     */
    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.doc_id</code>. 文章id
     */
    public Integer getDocId() {
        return this.docId;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.doc_id</code>. 文章id
     */
    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.user_id</code>. 用户id
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.user_id</code>. 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.ctx</code>. 评论内容
     */
    public String getCtx() {
        return this.ctx;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.ctx</code>. 评论内容
     */
    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.create_time</code>. 评论创建时间
     */
    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.create_time</code>. 评论创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * Getter for <code>document_manager.S1_COMMENT.parent_id</code>. 上级评论
     */
    public Integer getParentId() {
        return this.parentId;
    }

    /**
     * Setter for <code>document_manager.S1_COMMENT.parent_id</code>. 上级评论
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("S1CommentBO (");

        sb.append(primaryId);
        sb.append(", ").append(docId);
        sb.append(", ").append(userId);
        sb.append(", ").append(ctx);
        sb.append(", ").append(createTime);
        sb.append(", ").append(parentId);

        sb.append(")");
        return sb.toString();
    }
}
