package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:38 AM
 */

@Getter
public class AddUserHttpRequest {

    private RequsetHead head;

    private String name;

    private String password;

    private String bu;

    private boolean isAdmin;

    private int rank;
}
