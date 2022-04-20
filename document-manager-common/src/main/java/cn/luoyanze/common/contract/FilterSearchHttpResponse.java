package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.Pair;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.contract.entity.TableItemBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:47 AM
 */

@Data
public class FilterSearchHttpResponse{

    private ResponseHead head;

    @JsonProperty("items")
    private List<TableItemBase> items;

    @JsonProperty("pairs")
    private List<Pair> pairs;

    private int totalPage;

}
