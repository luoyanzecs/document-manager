package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

@Data
public class FileMenuHttpRequset {

    @JsonProperty("head")
    private RequestHead head;

    @JsonProperty("bu")
    private String bu;
}
