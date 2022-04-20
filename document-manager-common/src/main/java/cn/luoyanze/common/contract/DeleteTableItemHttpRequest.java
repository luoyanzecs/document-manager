package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import lombok.Getter;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:42 AM
 */

@Getter
public class DeleteTableItemHttpRequest {

    private RequsetHead head;

    private int type;

    private List<String> ids;
}
