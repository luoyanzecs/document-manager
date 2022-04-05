package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:04 PM
 */


public class NoticeInAdmin {

    /**
     * 条目id
     */
    @JsonProperty("id")
    private String itemId;

    /**
     * 接收用户
     */
    @JsonProperty("to")
    private String to;

    /**
     * 开始时间
     */
    @JsonProperty("startTime")
    private String startTime;

    /**
     * 结束时间
     */
    @JsonProperty("endTime")
    private String endTime;

    /**
     * 内容
     */
    @JsonProperty("ctx")
    private String ctx;

    /**
     * 所属部门
     */
    @JsonProperty("bu")
    private String bu;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }
}
