package cn.luoyanze.documentmanager.common.contract.entity;

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
    private Integer id;

    /**
     * 用户名
     */
    @JsonProperty("name")
    private String name;

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

    private String isDel;

    private String role;

    private String registerTime;

    private String status;

    private String lastLoginTime;

}
