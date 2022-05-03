package cn.luoyanze.documentmanager.service.service;

import cn.luoyanze.documentmanager.common.contract.LoginHttpRequest;
import cn.luoyanze.documentmanager.common.contract.LoginHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:24 PM
 */

public interface LoginApiService {

    LoginHttpResponse execute(LoginHttpRequest requset) throws Exception;
}
