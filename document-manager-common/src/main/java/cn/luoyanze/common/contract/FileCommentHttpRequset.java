package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */
@Getter
public class FileCommentHttpRequset {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("fileId")
    private String id;
}
