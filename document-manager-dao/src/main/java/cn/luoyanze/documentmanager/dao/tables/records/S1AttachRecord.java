/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.records;


import cn.luoyanze.documentmanager.dao.tables.S1AttachTB;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1AttachRecord extends UpdatableRecordImpl<S1AttachRecord> implements Record7<Integer, Integer, String, Long, LocalDateTime, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>document_manager.S1_ATTACH.primary_id</code>. 自增主键
     */
    public void setPrimaryId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.primary_id</code>. 自增主键
     */
    public Integer getPrimaryId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.doc_primary_id</code>. 文件ID
     */
    public void setDocPrimaryId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.doc_primary_id</code>. 文件ID
     */
    public Integer getDocPrimaryId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.name</code>. 文件名
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.name</code>. 文件名
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.size</code>. 文件大小
     */
    public void setSize(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.size</code>. 文件大小
     */
    public Long getSize() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.time</code>. 上传时间
     */
    public void setTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.time</code>. 上传时间
     */
    public LocalDateTime getTime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.user_primary_id</code>. 用户id
     */
    public void setUserPrimaryId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.user_primary_id</code>. 用户id
     */
    public Integer getUserPrimaryId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>document_manager.S1_ATTACH.isDel</code>. 是否删除
     */
    public void setIsdel(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>document_manager.S1_ATTACH.isDel</code>. 是否删除
     */
    public Integer getIsdel() {
        return (Integer) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, Integer, String, Long, LocalDateTime, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, Integer, String, Long, LocalDateTime, Integer, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return S1AttachTB.S1_ATTACH.PRIMARY_ID;
    }

    @Override
    public Field<Integer> field2() {
        return S1AttachTB.S1_ATTACH.DOC_PRIMARY_ID;
    }

    @Override
    public Field<String> field3() {
        return S1AttachTB.S1_ATTACH.NAME;
    }

    @Override
    public Field<Long> field4() {
        return S1AttachTB.S1_ATTACH.SIZE;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return S1AttachTB.S1_ATTACH.TIME;
    }

    @Override
    public Field<Integer> field6() {
        return S1AttachTB.S1_ATTACH.USER_PRIMARY_ID;
    }

    @Override
    public Field<Integer> field7() {
        return S1AttachTB.S1_ATTACH.ISDEL;
    }

    @Override
    public Integer component1() {
        return getPrimaryId();
    }

    @Override
    public Integer component2() {
        return getDocPrimaryId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public Long component4() {
        return getSize();
    }

    @Override
    public LocalDateTime component5() {
        return getTime();
    }

    @Override
    public Integer component6() {
        return getUserPrimaryId();
    }

    @Override
    public Integer component7() {
        return getIsdel();
    }

    @Override
    public Integer value1() {
        return getPrimaryId();
    }

    @Override
    public Integer value2() {
        return getDocPrimaryId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public Long value4() {
        return getSize();
    }

    @Override
    public LocalDateTime value5() {
        return getTime();
    }

    @Override
    public Integer value6() {
        return getUserPrimaryId();
    }

    @Override
    public Integer value7() {
        return getIsdel();
    }

    @Override
    public S1AttachRecord value1(Integer value) {
        setPrimaryId(value);
        return this;
    }

    @Override
    public S1AttachRecord value2(Integer value) {
        setDocPrimaryId(value);
        return this;
    }

    @Override
    public S1AttachRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public S1AttachRecord value4(Long value) {
        setSize(value);
        return this;
    }

    @Override
    public S1AttachRecord value5(LocalDateTime value) {
        setTime(value);
        return this;
    }

    @Override
    public S1AttachRecord value6(Integer value) {
        setUserPrimaryId(value);
        return this;
    }

    @Override
    public S1AttachRecord value7(Integer value) {
        setIsdel(value);
        return this;
    }

    @Override
    public S1AttachRecord values(Integer value1, Integer value2, String value3, Long value4, LocalDateTime value5, Integer value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached S1AttachRecord
     */
    public S1AttachRecord() {
        super(S1AttachTB.S1_ATTACH);
    }

    /**
     * Create a detached, initialised S1AttachRecord
     */
    public S1AttachRecord(Integer primaryId, Integer docPrimaryId, String name, Long size, LocalDateTime time, Integer userPrimaryId, Integer isdel) {
        super(S1AttachTB.S1_ATTACH);

        setPrimaryId(primaryId);
        setDocPrimaryId(docPrimaryId);
        setName(name);
        setSize(size);
        setTime(time);
        setUserPrimaryId(userPrimaryId);
        setIsdel(isdel);
    }
}