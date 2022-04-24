package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 5:04 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class NoticeTableItem extends TableItemBase{

    /**
     * 条目id
     */
    @JsonProperty("id")
    private Integer itemId;

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
}
