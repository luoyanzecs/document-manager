package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:44 AM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class DeleteTableItemHttpResponse extends BaseHttpResponse {

    private List<Integer> notDelete;
}
