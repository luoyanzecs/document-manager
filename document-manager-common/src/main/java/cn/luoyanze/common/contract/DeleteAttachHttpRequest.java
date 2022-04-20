package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:09 AM
 */

@Getter
public class DeleteAttachHttpRequest {

    private RequsetHead head;

    private String link;
}
