package cn.luoyanze.common.contract;


import cn.luoyanze.common.contract.common.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:46 AM
 */

@Data
public class FilterSearchHttpRequest {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("menuIndex")
    private int menuIndex;

    @JsonProperty("pageSize")
    private int pageSize;

    @JsonProperty("page")
    private int page;

    @JsonProperty("bu")
    private List<String> bu;

    @JsonProperty("userIds")
    private List<Integer> userIds;
}
