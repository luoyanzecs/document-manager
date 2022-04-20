package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:01 AM
 */

@Getter
public class LeaveMessageHttpRequest {

    private RequsetHead head;

    private String userId;

    private String fileId;

    private String ctx;
}
