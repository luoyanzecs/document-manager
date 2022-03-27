package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.UserMenuHttpRequset;
import cn.luoyanze.documentmanager.contract.UserMenuHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:17 PM
 */

@Service
public interface UserMenuApiService {

    UserMenuHttpResponse excute(UserMenuHttpRequset requset);
}
