package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.contract.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:45 PM
 */


public class LoginHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    /**
     * 状态
     */
    @JsonProperty("status")
    private boolean status;

    /**
     * 用户信息
     */
    @JsonProperty("userInfo")
    private User user;

    @JsonProperty("token")
    private String token;

    public LoginHttpResponse() {
    }

    public LoginHttpResponse(ResponseHead head, boolean status, User user, String token) {
        this.head = head;
        this.status = status;
        this.user = user;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }
}
