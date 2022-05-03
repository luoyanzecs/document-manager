package cn.luoyanze.documentmanager.common.contract;


import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:46 AM
 */

@Getter
public class FilterSearchHttpRequest extends BaseHttpRequest {

    @JsonProperty("menuIndex")
    private int menuIndex;

    @JsonProperty("pageSize")
    private int pageSize;

    @JsonProperty("page")
    private int page;

    @JsonProperty("bu")
    private List<Integer> bu;

    @JsonProperty("userids")
    private List<Integer> userIds;
}
