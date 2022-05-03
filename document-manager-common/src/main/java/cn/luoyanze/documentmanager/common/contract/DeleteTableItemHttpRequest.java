package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import lombok.Getter;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:42 AM
 */

@Getter
public class DeleteTableItemHttpRequest extends BaseHttpRequest {

    /**
     * 用户选择的目录
     */
    private int menuIndex;

    private List<Integer> ids;
}
