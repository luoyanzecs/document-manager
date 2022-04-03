package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:01 PM
 */


public class RecordInAdmin {

    /**
     * 条目id
     */
    @JsonProperty("id")
    private String itemId;

    /**
     * 用户名
     */
    @JsonProperty("fid")
    private String fid;

    /**
     * 操作时间
     */
    @JsonProperty("operateTime")
    private String operateTime;

    /**
     * 操作
     */
    @JsonProperty("operate")
    private String operate;

    /**
     * 所属部门
     */
    @JsonProperty("bu")
    private String bu;

    public RecordInAdmin(String itemId, String fid, String operateTime, String operate, String bu) {
        this.itemId = itemId;
        this.fid = fid;
        this.operateTime = operateTime;
        this.operate = operate;
        this.bu = bu;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }
}
