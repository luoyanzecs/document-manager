/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1UserBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UInteger      primaryId;
    private String        uuid;
    private String        account;
    private String        password;
    private String        role;
    private String        tel;
    private String        email;
    private LocalDateTime lastLoginTime;
    private LocalDateTime registerTime;
    private Integer       status;
    private String        bu;
    private Integer       authority;

    public S1UserBO() {}

    public S1UserBO(S1UserBO value) {
        this.primaryId = value.primaryId;
        this.uuid = value.uuid;
        this.account = value.account;
        this.password = value.password;
        this.role = value.role;
        this.tel = value.tel;
        this.email = value.email;
        this.lastLoginTime = value.lastLoginTime;
        this.registerTime = value.registerTime;
        this.status = value.status;
        this.bu = value.bu;
        this.authority = value.authority;
    }

    public S1UserBO(
        UInteger      primaryId,
        String        uuid,
        String        account,
        String        password,
        String        role,
        String        tel,
        String        email,
        LocalDateTime lastLoginTime,
        LocalDateTime registerTime,
        Integer       status,
        String        bu,
        Integer       authority
    ) {
        this.primaryId = primaryId;
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.role = role;
        this.tel = tel;
        this.email = email;
        this.lastLoginTime = lastLoginTime;
        this.registerTime = registerTime;
        this.status = status;
        this.bu = bu;
        this.authority = authority;
    }

    /**
     * Getter for <code>document_manager.S1_USER.primary_id</code>. 自增主键
     */
    public UInteger getPrimaryId() {
        return this.primaryId;
    }

    /**
     * Setter for <code>document_manager.S1_USER.primary_id</code>. 自增主键
     */
    public void setPrimaryId(UInteger primaryId) {
        this.primaryId = primaryId;
    }

    /**
     * Getter for <code>document_manager.S1_USER.uuid</code>. 用户UUID
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>document_manager.S1_USER.uuid</code>. 用户UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>document_manager.S1_USER.account</code>. 用户账号
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * Setter for <code>document_manager.S1_USER.account</code>. 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Getter for <code>document_manager.S1_USER.password</code>. 用户密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for <code>document_manager.S1_USER.password</code>. 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for <code>document_manager.S1_USER.role</code>. 角色
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Setter for <code>document_manager.S1_USER.role</code>. 角色
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter for <code>document_manager.S1_USER.tel</code>. 电话
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * Setter for <code>document_manager.S1_USER.tel</code>. 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Getter for <code>document_manager.S1_USER.email</code>. 电邮
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for <code>document_manager.S1_USER.email</code>. 电邮
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for <code>document_manager.S1_USER.last_login_time</code>. 最近一次登录时间
     */
    public LocalDateTime getLastLoginTime() {
        return this.lastLoginTime;
    }

    /**
     * Setter for <code>document_manager.S1_USER.last_login_time</code>. 最近一次登录时间
     */
    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Getter for <code>document_manager.S1_USER.register_time</code>. 注册时间
     */
    public LocalDateTime getRegisterTime() {
        return this.registerTime;
    }

    /**
     * Setter for <code>document_manager.S1_USER.register_time</code>. 注册时间
     */
    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * Getter for <code>document_manager.S1_USER.status</code>. 在职状态， 在职1， 不在职0
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>document_manager.S1_USER.status</code>. 在职状态， 在职1， 不在职0
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Getter for <code>document_manager.S1_USER.bu</code>. 用户部门
     */
    public String getBu() {
        return this.bu;
    }

    /**
     * Setter for <code>document_manager.S1_USER.bu</code>. 用户部门
     */
    public void setBu(String bu) {
        this.bu = bu;
    }

    /**
     * Getter for <code>document_manager.S1_USER.authority</code>. 权限等级
     */
    public Integer getAuthority() {
        return this.authority;
    }

    /**
     * Setter for <code>document_manager.S1_USER.authority</code>. 权限等级
     */
    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("S1UserBO (");

        sb.append(primaryId);
        sb.append(", ").append(uuid);
        sb.append(", ").append(account);
        sb.append(", ").append(password);
        sb.append(", ").append(role);
        sb.append(", ").append(tel);
        sb.append(", ").append(email);
        sb.append(", ").append(lastLoginTime);
        sb.append(", ").append(registerTime);
        sb.append(", ").append(status);
        sb.append(", ").append(bu);
        sb.append(", ").append(authority);

        sb.append(")");
        return sb.toString();
    }
}
