package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 4:44 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class FileTableItem extends TableItemBase{

    /**
     * 文件的id
     */
    @JsonProperty("id")
    private Integer fileId;

    /**
     * 文件创建者
     */
    @JsonProperty("owner")
    private String owner;

    /**
     * 文件创建者id
     */
    @JsonProperty("userId")
    private String userId;

    /**
     * 文件标题
     */
    @JsonProperty("title")
    private String title;

    /**
     * 文件所属部门
     */
    @JsonProperty("bu")
    private String bu;

    /**
     * 文件创建时间
     */
    @JsonProperty("createTime")
    private String time;
}
