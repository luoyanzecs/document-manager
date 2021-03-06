/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.records;


import cn.luoyanze.documentmanager.dao.tables.S1OperateTB;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1OperateRecord extends UpdatableRecordImpl<S1OperateRecord> implements Record6<Integer, Integer, LocalDateTime, Integer, Integer, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>document_manager.S1_OPERATE.primary_id</code>. 自增主键
     */
    public void setPrimaryId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.primary_id</code>. 自增主键
     */
    public Integer getPrimaryId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>document_manager.S1_OPERATE.type</code>. 操作类型
     */
    public void setType(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.type</code>. 操作类型
     */
    public Integer getType() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>document_manager.S1_OPERATE.time</code>. 操作时间
     */
    public void setTime(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.time</code>. 操作时间
     */
    public LocalDateTime getTime() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>document_manager.S1_OPERATE.doc_id</code>. 文章uuid
     */
    public void setDocId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.doc_id</code>. 文章uuid
     */
    public Integer getDocId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>document_manager.S1_OPERATE.user_id</code>. user uuid
     */
    public void setUserId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.user_id</code>. user uuid
     */
    public Integer getUserId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>document_manager.S1_OPERATE.content</code>. 内容保留字段
     */
    public void setContent(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>document_manager.S1_OPERATE.content</code>. 内容保留字段
     */
    public String getContent() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, LocalDateTime, Integer, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Integer, LocalDateTime, Integer, Integer, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return S1OperateTB.S1_OPERATE.PRIMARY_ID;
    }

    @Override
    public Field<Integer> field2() {
        return S1OperateTB.S1_OPERATE.TYPE;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return S1OperateTB.S1_OPERATE.TIME;
    }

    @Override
    public Field<Integer> field4() {
        return S1OperateTB.S1_OPERATE.DOC_ID;
    }

    @Override
    public Field<Integer> field5() {
        return S1OperateTB.S1_OPERATE.USER_ID;
    }

    @Override
    public Field<String> field6() {
        return S1OperateTB.S1_OPERATE.CONTENT;
    }

    @Override
    public Integer component1() {
        return getPrimaryId();
    }

    @Override
    public Integer component2() {
        return getType();
    }

    @Override
    public LocalDateTime component3() {
        return getTime();
    }

    @Override
    public Integer component4() {
        return getDocId();
    }

    @Override
    public Integer component5() {
        return getUserId();
    }

    @Override
    public String component6() {
        return getContent();
    }

    @Override
    public Integer value1() {
        return getPrimaryId();
    }

    @Override
    public Integer value2() {
        return getType();
    }

    @Override
    public LocalDateTime value3() {
        return getTime();
    }

    @Override
    public Integer value4() {
        return getDocId();
    }

    @Override
    public Integer value5() {
        return getUserId();
    }

    @Override
    public String value6() {
        return getContent();
    }

    @Override
    public S1OperateRecord value1(Integer value) {
        setPrimaryId(value);
        return this;
    }

    @Override
    public S1OperateRecord value2(Integer value) {
        setType(value);
        return this;
    }

    @Override
    public S1OperateRecord value3(LocalDateTime value) {
        setTime(value);
        return this;
    }

    @Override
    public S1OperateRecord value4(Integer value) {
        setDocId(value);
        return this;
    }

    @Override
    public S1OperateRecord value5(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public S1OperateRecord value6(String value) {
        setContent(value);
        return this;
    }

    @Override
    public S1OperateRecord values(Integer value1, Integer value2, LocalDateTime value3, Integer value4, Integer value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached S1OperateRecord
     */
    public S1OperateRecord() {
        super(S1OperateTB.S1_OPERATE);
    }

    /**
     * Create a detached, initialised S1OperateRecord
     */
    public S1OperateRecord(Integer primaryId, Integer type, LocalDateTime time, Integer docId, Integer userId, String content) {
        super(S1OperateTB.S1_OPERATE);

        setPrimaryId(primaryId);
        setType(type);
        setTime(time);
        setDocId(docId);
        setUserId(userId);
        setContent(content);
    }
}
