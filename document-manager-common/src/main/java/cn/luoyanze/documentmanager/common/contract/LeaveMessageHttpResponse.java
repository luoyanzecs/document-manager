package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:03 AM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class LeaveMessageHttpResponse extends BaseHttpResponse {

    /**
     * 添加成功返回主键
     */
    private Integer id;
}
