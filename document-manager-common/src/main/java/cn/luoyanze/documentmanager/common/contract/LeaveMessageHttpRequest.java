package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:01 AM
 */

@Getter
public class LeaveMessageHttpRequest extends BaseHttpRequest {

    private Integer fileId;

    private Integer parentCommentId;

    private String ctx;
}
