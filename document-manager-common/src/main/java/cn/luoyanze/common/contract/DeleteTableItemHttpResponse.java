package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import lombok.Data;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:44 AM
 */

@Data
public class DeleteTableItemHttpResponse {

    private ResponseHead head;

    private List<Integer> notDelete;
}
