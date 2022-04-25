package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */
@Getter
public class FileCommentHttpRequset {

    @JsonProperty("head")
    private RequestHead head;

    @JsonProperty("id")
    private Integer id;
}
