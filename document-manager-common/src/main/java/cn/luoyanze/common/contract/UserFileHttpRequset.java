package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

@Getter
public class UserFileHttpRequset {

    @JsonProperty("head")
    private RequestHead head;

    private Integer id;

}
