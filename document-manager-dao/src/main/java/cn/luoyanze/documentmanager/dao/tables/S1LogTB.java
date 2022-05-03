/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables;


import cn.luoyanze.documentmanager.dao.DocumentManager;
import cn.luoyanze.documentmanager.dao.Keys;
import cn.luoyanze.documentmanager.dao.tables.records.S1LogRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class S1LogTB extends TableImpl<S1LogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager.S1_LOG</code>
     */
    public static final S1LogTB S1_LOG = new S1LogTB();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<S1LogRecord> getRecordType() {
        return S1LogRecord.class;
    }

    /**
     * The column <code>document_manager.S1_LOG.logId</code>. 日志ID
     */
    public final TableField<S1LogRecord, Integer> LOGID = createField(DSL.name("logId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "日志ID");

    /**
     * The column <code>document_manager.S1_LOG.className</code>. 类名
     */
    public final TableField<S1LogRecord, String> CLASSNAME = createField(DSL.name("className"), SQLDataType.VARCHAR(200).nullable(false), this, "类名");

    /**
     * The column <code>document_manager.S1_LOG.methodName</code>. 方法名称
     */
    public final TableField<S1LogRecord, String> METHODNAME = createField(DSL.name("methodName"), SQLDataType.VARCHAR(100).nullable(false), this, "方法名称");

    /**
     * The column <code>document_manager.S1_LOG.exceptionName</code>. 异常类型
     */
    public final TableField<S1LogRecord, String> EXCEPTIONNAME = createField(DSL.name("exceptionName"), SQLDataType.VARCHAR(155).nullable(false), this, "异常类型");

    /**
     * The column <code>document_manager.S1_LOG.errMsg</code>. 错误信息
     */
    public final TableField<S1LogRecord, String> ERRMSG = createField(DSL.name("errMsg"), SQLDataType.VARCHAR(500), this, "错误信息");

    /**
     * The column <code>document_manager.S1_LOG.stackTrace</code>. 异常堆栈信息
     */
    public final TableField<S1LogRecord, String> STACKTRACE = createField(DSL.name("stackTrace"), SQLDataType.CLOB, this, "异常堆栈信息");

    /**
     * The column <code>document_manager.S1_LOG.createTime</code>. 创建时间
     */
    public final TableField<S1LogRecord, LocalDateTime> CREATETIME = createField(DSL.name("createTime"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "创建时间");

    private S1LogTB(Name alias, Table<S1LogRecord> aliased) {
        this(alias, aliased, null);
    }

    private S1LogTB(Name alias, Table<S1LogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>document_manager.S1_LOG</code> table reference
     */
    public S1LogTB(String alias) {
        this(DSL.name(alias), S1_LOG);
    }

    /**
     * Create an aliased <code>document_manager.S1_LOG</code> table reference
     */
    public S1LogTB(Name alias) {
        this(alias, S1_LOG);
    }

    /**
     * Create a <code>document_manager.S1_LOG</code> table reference
     */
    public S1LogTB() {
        this(DSL.name("S1_LOG"), null);
    }

    public <O extends Record> S1LogTB(Table<O> child, ForeignKey<O, S1LogRecord> key) {
        super(child, key, S1_LOG);
    }

    @Override
    public Schema getSchema() {
        return DocumentManager.DOCUMENT_MANAGER;
    }

    @Override
    public Identity<S1LogRecord, Integer> getIdentity() {
        return (Identity<S1LogRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<S1LogRecord> getPrimaryKey() {
        return Keys.KEY_S1_LOG_PRIMARY;
    }

    @Override
    public List<UniqueKey<S1LogRecord>> getKeys() {
        return Arrays.<UniqueKey<S1LogRecord>>asList(Keys.KEY_S1_LOG_PRIMARY);
    }

    @Override
    public S1LogTB as(String alias) {
        return new S1LogTB(DSL.name(alias), this);
    }

    @Override
    public S1LogTB as(Name alias) {
        return new S1LogTB(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public S1LogTB rename(String name) {
        return new S1LogTB(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public S1LogTB rename(Name name) {
        return new S1LogTB(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}