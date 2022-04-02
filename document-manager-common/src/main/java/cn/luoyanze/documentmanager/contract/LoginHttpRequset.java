package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:45 PM
 */


public class LoginHttpRequset {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public RequsetHead getHead() {
        return head;
    }

    public void setHead(RequsetHead head) {
        this.head = head;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
