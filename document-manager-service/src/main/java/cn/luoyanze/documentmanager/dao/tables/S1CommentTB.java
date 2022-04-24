/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables;


import cn.luoyanze.documentmanager.dao.DocumentManager;
import cn.luoyanze.documentmanager.dao.Keys;
import cn.luoyanze.documentmanager.dao.tables.records.S1CommentRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1CommentTB extends TableImpl<S1CommentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager.S1_COMMENT</code>
     */
    public static final S1CommentTB S1_COMMENT = new S1CommentTB();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S1CommentRecord> getRecordType() {
        return S1CommentRecord.class;
    }

    /**
     * The column <code>document_manager.S1_COMMENT.primary_id</code>. 自增主键
     */
    public final TableField<S1CommentRecord, UInteger> PRIMARY_ID = createField(DSL.name("primary_id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "自增主键");

    /**
     * The column <code>document_manager.S1_COMMENT.doc_id</code>. 文章id
     */
    public final TableField<S1CommentRecord, UInteger> DOC_ID = createField(DSL.name("doc_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "文章id");

    /**
     * The column <code>document_manager.S1_COMMENT.user_id</code>. 用户id
     */
    public final TableField<S1CommentRecord, UInteger> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "用户id");

    /**
     * The column <code>document_manager.S1_COMMENT.ctx</code>. 评论内容
     */
    public final TableField<S1CommentRecord, String> CTX = createField(DSL.name("ctx"), SQLDataType.VARCHAR(2048).nullable(false), this, "评论内容");

    /**
     * The column <code>document_manager.S1_COMMENT.create_time</code>. 评论创建时间
     */
    public final TableField<S1CommentRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "评论创建时间");

    /**
     * The column <code>document_manager.S1_COMMENT.parent_id</code>. 上级评论
     */
    public final TableField<S1CommentRecord, UInteger> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "上级评论");

    private S1CommentTB(Name alias, Table<S1CommentRecord> aliased) {
        this(alias, aliased, null);
    }

    private S1CommentTB(Name alias, Table<S1CommentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>document_manager.S1_COMMENT</code> table reference
     */
    public S1CommentTB(String alias) {
        this(DSL.name(alias), S1_COMMENT);
    }

    /**
     * Create an aliased <code>document_manager.S1_COMMENT</code> table reference
     */
    public S1CommentTB(Name alias) {
        this(alias, S1_COMMENT);
    }

    /**
     * Create a <code>document_manager.S1_COMMENT</code> table reference
     */
    public S1CommentTB() {
        this(DSL.name("S1_COMMENT"), null);
    }

    public <O extends Record> S1CommentTB(Table<O> child, ForeignKey<O, S1CommentRecord> key) {
        super(child, key, S1_COMMENT);
    }

    @Override
    public Schema getSchema() {
        return DocumentManager.DOCUMENT_MANAGER;
    }

    @Override
    public Identity<S1CommentRecord, UInteger> getIdentity() {
        return (Identity<S1CommentRecord, UInteger>) super.getIdentity();
    }

    @Override
    public UniqueKey<S1CommentRecord> getPrimaryKey() {
        return Keys.KEY_S1_COMMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<S1CommentRecord>> getKeys() {
        return Arrays.<UniqueKey<S1CommentRecord>>asList(Keys.KEY_S1_COMMENT_PRIMARY);
    }

    @Override
    public S1CommentTB as(String alias) {
        return new S1CommentTB(DSL.name(alias), this);
    }

    @Override
    public S1CommentTB as(Name alias) {
        return new S1CommentTB(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S1CommentTB rename(String name) {
        return new S1CommentTB(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S1CommentTB rename(Name name) {
        return new S1CommentTB(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UInteger, UInteger, UInteger, String, LocalDateTime, UInteger> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
