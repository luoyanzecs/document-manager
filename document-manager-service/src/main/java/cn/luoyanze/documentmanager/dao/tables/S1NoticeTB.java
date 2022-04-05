/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables;


import cn.luoyanze.documentmanager.dao.DocumentManager;
import cn.luoyanze.documentmanager.dao.Keys;
import cn.luoyanze.documentmanager.dao.tables.records.S1NoticeRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
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
public class S1NoticeTB extends TableImpl<S1NoticeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager.S1_NOTICE</code>
     */
    public static final S1NoticeTB S1_NOTICE = new S1NoticeTB();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S1NoticeRecord> getRecordType() {
        return S1NoticeRecord.class;
    }

    /**
     * The column <code>document_manager.S1_NOTICE.primary_id</code>. 自增主键
     */
    public final TableField<S1NoticeRecord, UInteger> PRIMARY_ID = createField(DSL.name("primary_id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "自增主键");

    /**
     * The column <code>document_manager.S1_NOTICE.uuid</code>. UUID
     */
    public final TableField<S1NoticeRecord, String> UUID = createField(DSL.name("uuid"), SQLDataType.CHAR(32).nullable(false), this, "UUID");

    /**
     * The column <code>document_manager.S1_NOTICE.type</code>. 内容type
     */
    public final TableField<S1NoticeRecord, Integer> TYPE = createField(DSL.name("type"), SQLDataType.INTEGER.nullable(false), this, "内容type");

    /**
     * The column <code>document_manager.S1_NOTICE.content</code>. 内容
     */
    public final TableField<S1NoticeRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR(1024).nullable(false), this, "内容");

    /**
     * The column <code>document_manager.S1_NOTICE.start_time</code>. 起始时间
     */
    public final TableField<S1NoticeRecord, LocalDateTime> START_TIME = createField(DSL.name("start_time"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "起始时间");

    /**
     * The column <code>document_manager.S1_NOTICE.end_time</code>. 结束时间
     */
    public final TableField<S1NoticeRecord, LocalDateTime> END_TIME = createField(DSL.name("end_time"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "结束时间");

    /**
     * The column <code>document_manager.S1_NOTICE.accept_users</code>. 接收用户列表 逗号分隔
     */
    public final TableField<S1NoticeRecord, String> ACCEPT_USERS = createField(DSL.name("accept_users"), SQLDataType.VARCHAR(1024), this, "接收用户列表 逗号分隔");

    /**
     * The column <code>document_manager.S1_NOTICE.accept_bu</code>. 接收部门列表, 逗号分隔
     */
    public final TableField<S1NoticeRecord, String> ACCEPT_BU = createField(DSL.name("accept_bu"), SQLDataType.VARCHAR(1024), this, "接收部门列表, 逗号分隔");

    /**
     * The column <code>document_manager.S1_NOTICE.is_global</code>. 是否全局通知 1全局
     */
    public final TableField<S1NoticeRecord, Integer> IS_GLOBAL = createField(DSL.name("is_global"), SQLDataType.INTEGER, this, "是否全局通知 1全局");

    private S1NoticeTB(Name alias, Table<S1NoticeRecord> aliased) {
        this(alias, aliased, null);
    }

    private S1NoticeTB(Name alias, Table<S1NoticeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>document_manager.S1_NOTICE</code> table reference
     */
    public S1NoticeTB(String alias) {
        this(DSL.name(alias), S1_NOTICE);
    }

    /**
     * Create an aliased <code>document_manager.S1_NOTICE</code> table reference
     */
    public S1NoticeTB(Name alias) {
        this(alias, S1_NOTICE);
    }

    /**
     * Create a <code>document_manager.S1_NOTICE</code> table reference
     */
    public S1NoticeTB() {
        this(DSL.name("S1_NOTICE"), null);
    }

    public <O extends Record> S1NoticeTB(Table<O> child, ForeignKey<O, S1NoticeRecord> key) {
        super(child, key, S1_NOTICE);
    }

    @Override
    public Schema getSchema() {
        return DocumentManager.DOCUMENT_MANAGER;
    }

    @Override
    public Identity<S1NoticeRecord, UInteger> getIdentity() {
        return (Identity<S1NoticeRecord, UInteger>) super.getIdentity();
    }

    @Override
    public UniqueKey<S1NoticeRecord> getPrimaryKey() {
        return Keys.KEY_S1_NOTICE_PRIMARY;
    }

    @Override
    public List<UniqueKey<S1NoticeRecord>> getKeys() {
        return Arrays.<UniqueKey<S1NoticeRecord>>asList(Keys.KEY_S1_NOTICE_PRIMARY);
    }

    @Override
    public S1NoticeTB as(String alias) {
        return new S1NoticeTB(DSL.name(alias), this);
    }

    @Override
    public S1NoticeTB as(Name alias) {
        return new S1NoticeTB(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S1NoticeTB rename(String name) {
        return new S1NoticeTB(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S1NoticeTB rename(Name name) {
        return new S1NoticeTB(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<UInteger, String, Integer, String, LocalDateTime, LocalDateTime, String, String, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
