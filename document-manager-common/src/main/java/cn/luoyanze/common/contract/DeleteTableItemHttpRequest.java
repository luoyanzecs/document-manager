package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import lombok.Getter;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:42 AM
 */

@Getter
public class DeleteTableItemHttpRequest {

    private RequestHead head;

    private int type;

    /**
     * 用户选择的目录
     */
    private int menuIndex;

    private List<String> ids;
}
