/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables;


import cn.luoyanze.documentmanager.dao.DocumentManager;
import cn.luoyanze.documentmanager.dao.Keys;
import cn.luoyanze.documentmanager.dao.tables.records.S1DirRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class S1DirTB extends TableImpl<S1DirRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager.S1_DIR</code>
     */
    public static final S1DirTB S1_DIR = new S1DirTB();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S1DirRecord> getRecordType() {
        return S1DirRecord.class;
    }

    /**
     * The column <code>document_manager.S1_DIR.primary_id</code>. 自增主键
     */
    public final TableField<S1DirRecord, UInteger> PRIMARY_ID = createField(DSL.name("primary_id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "自增主键");

    /**
     * The column <code>document_manager.S1_DIR.title</code>. 标题
     */
    public final TableField<S1DirRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.CLOB.nullable(false), this, "标题");

    /**
     * The column <code>document_manager.S1_DIR.parent_id</code>. 上级目录ID
     */
    public final TableField<S1DirRecord, UInteger> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "上级目录ID");

    /**
     * The column <code>document_manager.S1_DIR.bu</code>. 所属部门
     */
    public final TableField<S1DirRecord, String> BU = createField(DSL.name("bu"), SQLDataType.CHAR(16).nullable(false), this, "所属部门");

    /**
     * The column <code>document_manager.S1_DIR.deep</code>. 目录层级
     */
    public final TableField<S1DirRecord, Integer> DEEP = createField(DSL.name("deep"), SQLDataType.INTEGER.nullable(false), this, "目录层级");

    private S1DirTB(Name alias, Table<S1DirRecord> aliased) {
        this(alias, aliased, null);
    }

    private S1DirTB(Name alias, Table<S1DirRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>document_manager.S1_DIR</code> table reference
     */
    public S1DirTB(String alias) {
        this(DSL.name(alias), S1_DIR);
    }

    /**
     * Create an aliased <code>document_manager.S1_DIR</code> table reference
     */
    public S1DirTB(Name alias) {
        this(alias, S1_DIR);
    }

    /**
     * Create a <code>document_manager.S1_DIR</code> table reference
     */
    public S1DirTB() {
        this(DSL.name("S1_DIR"), null);
    }

    public <O extends Record> S1DirTB(Table<O> child, ForeignKey<O, S1DirRecord> key) {
        super(child, key, S1_DIR);
    }

    @Override
    public Schema getSchema() {
        return DocumentManager.DOCUMENT_MANAGER;
    }

    @Override
    public Identity<S1DirRecord, UInteger> getIdentity() {
        return (Identity<S1DirRecord, UInteger>) super.getIdentity();
    }

    @Override
    public UniqueKey<S1DirRecord> getPrimaryKey() {
        return Keys.KEY_S1_DIR_PRIMARY;
    }

    @Override
    public List<UniqueKey<S1DirRecord>> getKeys() {
        return Arrays.<UniqueKey<S1DirRecord>>asList(Keys.KEY_S1_DIR_PRIMARY);
    }

    @Override
    public S1DirTB as(String alias) {
        return new S1DirTB(DSL.name(alias), this);
    }

    @Override
    public S1DirTB as(Name alias) {
        return new S1DirTB(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S1DirTB rename(String name) {
        return new S1DirTB(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S1DirTB rename(Name name) {
        return new S1DirTB(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UInteger, String, UInteger, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
