package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author
 * @date 2022/5/2 16:23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CheckHealthHttpResponse extends BaseHttpResponse {
    @JsonProperty("items")
    private LinkedHashMap  items;
}
