package cn.luoyanze.common.contract.common;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 8:38 PM
 */


public class RequestHead {

    private String timestamp;

    private String username;

    private String role;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
