package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:52 PM
 */


@Getter
public class CreateFileHttpRequest extends BaseHttpRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("bu")
    private String bu;

    @JsonProperty("isDir")
    private Boolean isDir;

    @JsonProperty("parentId")
    private Integer parentId;
}
