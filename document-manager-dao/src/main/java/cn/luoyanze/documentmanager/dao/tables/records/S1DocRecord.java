/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.records;


import cn.luoyanze.documentmanager.dao.tables.S1DocTB;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1DocRecord extends UpdatableRecordImpl<S1DocRecord> implements Record9<Integer, String, Integer, Integer, LocalDateTime, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>document_manager.S1_DOC.primary_id</code>. 自增主键
     */
    public void setPrimaryId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.primary_id</code>. 自增主键
     */
    public Integer getPrimaryId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.permission_bu</code>. 允许的部门
     */
    public void setPermissionBu(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.permission_bu</code>. 允许的部门
     */
    public String getPermissionBu() {
        return (String) get(1);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.authority</code>. 允许的等级
     */
    public void setAuthority(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.authority</code>. 允许的等级
     */
    public Integer getAuthority() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.user_id</code>. 创建用户id
     */
    public void setUserId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.user_id</code>. 创建用户id
     */
    public Integer getUserId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.last_update_time</code>. 最近修改时间登录时间
     */
    public void setLastUpdateTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.last_update_time</code>. 最近修改时间登录时间
     */
    public LocalDateTime getLastUpdateTime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.title</code>. 标题
     */
    public void setTitle(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.title</code>. 标题
     */
    public String getTitle() {
        return (String) get(5);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.dir_id</code>. 上级目录ID
     */
    public void setDirId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.dir_id</code>. 上级目录ID
     */
    public Integer getDirId() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.last_update_user_id</code>. 最近修改用户id
     */
    public void setLastUpdateUserId(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.last_update_user_id</code>. 最近修改用户id
     */
    public Integer getLastUpdateUserId() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>document_manager.S1_DOC.isDel</code>. 0表示正常， 1为删除
     */
    public void setIsdel(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>document_manager.S1_DOC.isDel</code>. 0表示正常， 1为删除
     */
    public Integer getIsdel() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, Integer, Integer, LocalDateTime, String, Integer, Integer, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, Integer, Integer, LocalDateTime, String, Integer, Integer, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return S1DocTB.S1_DOC.PRIMARY_ID;
    }

    @Override
    public Field<String> field2() {
        return S1DocTB.S1_DOC.PERMISSION_BU;
    }

    @Override
    public Field<Integer> field3() {
        return S1DocTB.S1_DOC.AUTHORITY;
    }

    @Override
    public Field<Integer> field4() {
        return S1DocTB.S1_DOC.USER_ID;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return S1DocTB.S1_DOC.LAST_UPDATE_TIME;
    }

    @Override
    public Field<String> field6() {
        return S1DocTB.S1_DOC.TITLE;
    }

    @Override
    public Field<Integer> field7() {
        return S1DocTB.S1_DOC.DIR_ID;
    }

    @Override
    public Field<Integer> field8() {
        return S1DocTB.S1_DOC.LAST_UPDATE_USER_ID;
    }

    @Override
    public Field<Integer> field9() {
        return S1DocTB.S1_DOC.ISDEL;
    }

    @Override
    public Integer component1() {
        return getPrimaryId();
    }

    @Override
    public String component2() {
        return getPermissionBu();
    }

    @Override
    public Integer component3() {
        return getAuthority();
    }

    @Override
    public Integer component4() {
        return getUserId();
    }

    @Override
    public LocalDateTime component5() {
        return getLastUpdateTime();
    }

    @Override
    public String component6() {
        return getTitle();
    }

    @Override
    public Integer component7() {
        return getDirId();
    }

    @Override
    public Integer component8() {
        return getLastUpdateUserId();
    }

    @Override
    public Integer component9() {
        return getIsdel();
    }

    @Override
    public Integer value1() {
        return getPrimaryId();
    }

    @Override
    public String value2() {
        return getPermissionBu();
    }

    @Override
    public Integer value3() {
        return getAuthority();
    }

    @Override
    public Integer value4() {
        return getUserId();
    }

    @Override
    public LocalDateTime value5() {
        return getLastUpdateTime();
    }

    @Override
    public String value6() {
        return getTitle();
    }

    @Override
    public Integer value7() {
        return getDirId();
    }

    @Override
    public Integer value8() {
        return getLastUpdateUserId();
    }

    @Override
    public Integer value9() {
        return getIsdel();
    }

    @Override
    public S1DocRecord value1(Integer value) {
        setPrimaryId(value);
        return this;
    }

    @Override
    public S1DocRecord value2(String value) {
        setPermissionBu(value);
        return this;
    }

    @Override
    public S1DocRecord value3(Integer value) {
        setAuthority(value);
        return this;
    }

    @Override
    public S1DocRecord value4(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public S1DocRecord value5(LocalDateTime value) {
        setLastUpdateTime(value);
        return this;
    }

    @Override
    public S1DocRecord value6(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public S1DocRecord value7(Integer value) {
        setDirId(value);
        return this;
    }

    @Override
    public S1DocRecord value8(Integer value) {
        setLastUpdateUserId(value);
        return this;
    }

    @Override
    public S1DocRecord value9(Integer value) {
        setIsdel(value);
        return this;
    }

    @Override
    public S1DocRecord values(Integer value1, String value2, Integer value3, Integer value4, LocalDateTime value5, String value6, Integer value7, Integer value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached S1DocRecord
     */
    public S1DocRecord() {
        super(S1DocTB.S1_DOC);
    }

    /**
     * Create a detached, initialised S1DocRecord
     */
    public S1DocRecord(Integer primaryId, String permissionBu, Integer authority, Integer userId, LocalDateTime lastUpdateTime, String title, Integer dirId, Integer lastUpdateUserId, Integer isdel) {
        super(S1DocTB.S1_DOC);

        setPrimaryId(primaryId);
        setPermissionBu(permissionBu);
        setAuthority(authority);
        setUserId(userId);
        setLastUpdateTime(lastUpdateTime);
        setTitle(title);
        setDirId(dirId);
        setLastUpdateUserId(lastUpdateUserId);
        setIsdel(isdel);
    }
}