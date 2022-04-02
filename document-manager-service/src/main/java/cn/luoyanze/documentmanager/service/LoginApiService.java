package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.LoginHttpRequset;
import cn.luoyanze.documentmanager.contract.LoginHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:24 PM
 */

public interface LoginApiService {

    LoginHttpResponse excute(LoginHttpRequset requset);
}
