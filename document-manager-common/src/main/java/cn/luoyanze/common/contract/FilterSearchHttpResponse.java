package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.entity.Pair;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.contract.entity.TableItemBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:47 AM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class FilterSearchHttpResponse extends BaseHttpResponse {

    @JsonProperty("items")
    private List<TableItemBase> items;

    @JsonProperty("pairs")
    private List<Pair> pairs;

    private int totalPage;

}
