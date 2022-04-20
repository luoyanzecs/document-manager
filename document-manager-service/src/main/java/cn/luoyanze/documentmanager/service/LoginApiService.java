package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.LoginHttpRequset;
import cn.luoyanze.common.contract.LoginHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:24 PM
 */

public interface LoginApiService {

    LoginHttpResponse execute(LoginHttpRequset requset);
}
