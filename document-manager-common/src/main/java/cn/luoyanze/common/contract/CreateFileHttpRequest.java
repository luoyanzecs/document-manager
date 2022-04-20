package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:52 PM
 */


@Getter
public class CreateFileHttpRequest {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("title")
    private String title;

    @JsonProperty("bu")
    private String bu;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("isDir")
    private Boolean isDir;

    @JsonProperty("parentId")
    private String parentId;
}
