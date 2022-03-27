package cn.luoyanze.documentmanager.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:09 PM
 */


public class Notice {

    @JsonProperty("id")
    private String id;

    /**
     * 消息类型 1：成功； 2：失败； 其他：普通信息
     */
    @JsonProperty("type")
    private int type;

    @JsonProperty("message")
    private String message;

    public Notice(String id, int type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
