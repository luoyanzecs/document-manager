package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:17 PM
 */

public class User {
    /**
     * 用户名
     */
    @JsonProperty("name")
    private String name;

    /**
     * 头像
     */
    @JsonProperty("avatar")
    private String avatar;

    /**
     * 用户id
     */
    @JsonProperty("id")
    private String id;

    /**
     * 用户所在部门
     */
    @JsonProperty("bu")
    private String bu;

    /**
     * 用户等级
     */
    @JsonProperty("rank")
    private int rank;

    public User(String name, String avatar, String id, String bu, int rank) {
        this.name = name;
        this.avatar = avatar;
        this.id = id;
        this.bu = bu;
        this.rank = rank;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
