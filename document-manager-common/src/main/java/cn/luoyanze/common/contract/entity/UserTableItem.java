package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:55 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserTableItem extends TableItemBase{

    /**
     * 条目id
     */
    @JsonProperty("id")
    private Integer itemId;

    /**
     * 用户名
     */
    @JsonProperty("name")
    private String name;

    /**
     * 用户id
     */
    @JsonProperty("userId")
    private Integer userId;

    /**
     * 用户部门
     */
    @JsonProperty("bu")
    private String bu;

    /**
     * 用户联系方式
     */
    @JsonProperty("tel")
    private String tel;
}
