package cn.luoyanze.common.contract.entity;

import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:28 AM
 */
public class ResponseHead {
    /**
     * 状态 成功：success， 失败：error
     */
    private String status;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 消息
     */
    private String massage;

    /**
     * 时间戳
     */
    private long timestamp;

    public ResponseHead(HeadStatus head) {
        this.status = head == HeadStatus.SUCCESS ? "success" : "error";
        this.statusCode = head.getCode();
        this.massage = head.getValue();
        this.timestamp = TimeUtil.getTimeStamp();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
