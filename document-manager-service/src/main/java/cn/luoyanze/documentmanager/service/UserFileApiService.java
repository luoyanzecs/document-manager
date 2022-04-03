package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.UserFileHttpRequset;
import cn.luoyanze.common.contract.UserFileHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:20 PM
 */

public interface UserFileApiService {

    UserFileHttpResponse excute(UserFileHttpRequset requset);
}
