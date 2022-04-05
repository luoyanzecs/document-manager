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
    @JsonProperty("itemId")
    private String itemId;


    @JsonProperty("id")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
