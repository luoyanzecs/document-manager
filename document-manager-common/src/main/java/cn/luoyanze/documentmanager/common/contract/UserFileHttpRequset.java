package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

@Getter
public class UserFileHttpRequset extends BaseHttpRequest {

    private Integer id;
}
