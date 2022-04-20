package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import lombok.Data;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 3:18 PM
 */


@Data
public class GetBuHttpResponse {
    private ResponseHead head;

    private List<String> buList;

    public ResponseHead getHead() {
        return head;
    }
}
