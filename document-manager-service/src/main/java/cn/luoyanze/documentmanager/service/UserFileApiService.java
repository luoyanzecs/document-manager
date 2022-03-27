package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.UserFileHttpRequset;
import cn.luoyanze.documentmanager.contract.UserFileHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:20 PM
 */

@Service
public interface UserFileApiService {

    UserFileHttpResponse excute(UserFileHttpRequset requset);
}
