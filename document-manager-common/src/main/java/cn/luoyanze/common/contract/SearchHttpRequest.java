package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:49 AM
 */

@Getter
public class SearchHttpRequest extends BaseHttpRequest {

    private String input;
}
