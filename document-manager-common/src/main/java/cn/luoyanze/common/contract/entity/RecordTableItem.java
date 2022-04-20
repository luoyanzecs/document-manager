package cn.luoyanze.common.contract.entity;

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
}
