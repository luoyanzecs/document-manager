package cn.luoyanze.documentmanager.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:01 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class RecordTableItem extends TableItemBase{

    /**
     * 条目id
     */
    @JsonProperty("itemId")
    private Integer itemId;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("fid")
    private Integer fid;

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

    private String content;

    /**
     * 操作用户性名
     */
    private String operator;
}