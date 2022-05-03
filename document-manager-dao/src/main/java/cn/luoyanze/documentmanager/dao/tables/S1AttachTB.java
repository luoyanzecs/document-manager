/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables;


import cn.luoyanze.documentmanager.dao.DocumentManager;
import cn.luoyanze.documentmanager.dao.Indexes;
import cn.luoyanze.documentmanager.dao.Keys;
import cn.luoyanze.documentmanager.dao.tables.records.S1AttachRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1AttachTB extends TableImpl<S1AttachRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager.S1_ATTACH</code>
     */
    public static final S1AttachTB S1_ATTACH = new S1AttachTB();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S1AttachRecord> getRecordType() {
        return S1AttachRecord.class;
    }

    /**
     * The column <code>document_manager.S1_ATTACH.primary_id</code>. 自增主键
     */
    public final TableField<S1AttachRecord, Integer> PRIMARY_ID = createField(DSL.name("primary_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "自增主键");

    /**
     * The column <code>document_manager.S1_ATTACH.doc_primary_id</code>. 文件ID
     */
    public final TableField<S1AttachRecord, Integer> DOC_PRIMARY_ID = createField(DSL.name("doc_primary_id"), SQLDataType.INTEGER.nullable(false), this, "文件ID");

    /**
     * The column <code>document_manager.S1_ATTACH.name</code>. 文件名
     */
    public final TableField<S1AttachRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(1024).nullable(false), this, "文件名");

    /**
     * The column <code>document_manager.S1_ATTACH.size</code>. 文件大小
     */
    public final TableField<S1AttachRecord, Long> SIZE = createField(DSL.name("size"), SQLDataType.BIGINT.nullable(false), this, "文件大小");

    /**
     * The column <code>document_manager.S1_ATTACH.time</code>. 上传时间
     */
    public final TableField<S1AttachRecord, LocalDateTime> TIME = createField(DSL.name("time"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "上传时间");

    /**
     * The column <code>document_manager.S1_ATTACH.user_primary_id</code>. 用户id
     */
    public final TableField<S1AttachRecord, Integer> USER_PRIMARY_ID = createField(DSL.name("user_primary_id"), SQLDataType.INTEGER.nullable(false), this, "用户id");

    /**
     * The column <code>document_manager.S1_ATTACH.isDel</code>. 是否删除
     */
    public final TableField<S1AttachRecord, Integer> ISDEL = createField(DSL.name("isDel"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "是否删除");

    private S1AttachTB(Name alias, Table<S1AttachRecord> aliased) {
        this(alias, aliased, null);
    }

    private S1AttachTB(Name alias, Table<S1AttachRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>document_manager.S1_ATTACH</code> table reference
     */
    public S1AttachTB(String alias) {
        this(DSL.name(alias), S1_ATTACH);
    }

    /**
     * Create an aliased <code>document_manager.S1_ATTACH</code> table reference
     */
    public S1AttachTB(Name alias) {
        this(alias, S1_ATTACH);
    }

    /**
     * Create a <code>document_manager.S1_ATTACH</code> table reference
     */
    public S1AttachTB() {
        this(DSL.name("S1_ATTACH"), null);
    }

    public <O extends Record> S1AttachTB(Table<O> child, ForeignKey<O, S1AttachRecord> key) {
        super(child, key, S1_ATTACH);
    }

    @Override
    public Schema getSchema() {
        return DocumentManager.DOCUMENT_MANAGER;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.S1_ATTACH_DOC_PRIMARY_ID, Indexes.S1_ATTACH_USER_PRIMARY_ID);
    }

    @Override
    public Identity<S1AttachRecord, Integer> getIdentity() {
        return (Identity<S1AttachRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<S1AttachRecord> getPrimaryKey() {
        return Keys.KEY_S1_ATTACH_PRIMARY;
    }

    @Override
    public List<UniqueKey<S1AttachRecord>> getKeys() {
        return Arrays.<UniqueKey<S1AttachRecord>>asList(Keys.KEY_S1_ATTACH_PRIMARY);
    }

    @Override
    public List<ForeignKey<S1AttachRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<S1AttachRecord, ?>>asList(Keys.S1_ATTACH_IBFK_1, Keys.S1_ATTACH_IBFK_2);
    }

    private transient S1DocTB _s1Doc;
    private transient S1UserTB _s1User;

    public S1DocTB s1Doc() {
        if (_s1Doc == null)
            _s1Doc = new S1DocTB(this, Keys.S1_ATTACH_IBFK_1);

        return _s1Doc;
    }

    public S1UserTB s1User() {
        if (_s1User == null)
            _s1User = new S1UserTB(this, Keys.S1_ATTACH_IBFK_2);

        return _s1User;
    }

    @Override
    public S1AttachTB as(String alias) {
        return new S1AttachTB(DSL.name(alias), this);
    }

    @Override
    public S1AttachTB as(Name alias) {
        return new S1AttachTB(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S1AttachTB rename(String name) {
        return new S1AttachTB(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S1AttachTB rename(Name name) {
        return new S1AttachTB(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, Long, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}