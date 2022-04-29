package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
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
