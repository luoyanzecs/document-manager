package cn.luoyanze.common.contract.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/29 8:47 PM
 */

@Getter
public abstract class BaseHttpRequest {

    @JsonProperty("head")
    private RequestHead head;
}
