package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:38 AM
 */

@Getter
public class AddUserHttpRequest extends BaseHttpRequest {

    private String name;

    private String password;

    private int bu;

    private boolean isAdmin;

    private int rank;
}
