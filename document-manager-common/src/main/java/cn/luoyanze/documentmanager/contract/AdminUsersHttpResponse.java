package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.Head;
import cn.luoyanze.documentmanager.contract.entity.UserInAdmin;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:42 PM
 *
 */

public class AdminUsersHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private Head head;

    @JsonProperty("fields")
    private List<String> fields;

    @JsonProperty("keys")
    private List<String> keys;

    @JsonProperty("cols")
    private List<Integer> cols;

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("totalPage")
    private Integer totalPage;

    /**
     * 用户列表
     */
    @JsonProperty("items")
    private List<UserInAdmin> users;

    public AdminUsersHttpResponse(Head head, List<String> fields, List<String> keys, List<Integer> cols, Integer currentPage, Integer totalPage, List<UserInAdmin> users) {
        this.head = head;
        this.fields = fields;
        this.keys = keys;
        this.cols = cols;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.users = users;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Integer> getCols() {
        return cols;
    }

    public void setCols(List<Integer> cols) {
        this.cols = cols;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<UserInAdmin> getUsers() {
        return users;
    }

    public void setUsers(List<UserInAdmin> users) {
        this.users = users;
    }
}
