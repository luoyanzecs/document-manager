package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:09 AM
 */

@Getter
public class DeleteAttachHttpRequest extends BaseHttpRequest {

    private Integer attachId;
}
