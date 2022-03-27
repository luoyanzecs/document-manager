package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:55 PM
 */

public class UserInAdmin {

    /**
     * 条目id
     */
    @JsonProperty("id")
    private String itemId;

    /**
     * 用户名
     */
    @JsonProperty("name")
    private String name;

    /**
     * 用户id
     */
    @JsonProperty("userId")
    private String userId;

    /**
     * 用户部门
     */
    @JsonProperty("bu")
    private String bu;

    /**
     * 用户联系方式
     */
    @JsonProperty("tel")
    private String tel;

    public UserInAdmin(String itemId, String name, String userId, String bu, String tel) {
        this.itemId = itemId;
        this.name = name;
        this.userId = userId;
        this.bu = bu;
        this.tel = tel;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
