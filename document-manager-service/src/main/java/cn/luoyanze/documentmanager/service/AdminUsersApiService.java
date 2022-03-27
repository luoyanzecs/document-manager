package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.AdminUsersHttpRequest;
import cn.luoyanze.documentmanager.contract.AdminUsersHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:04 PM
 */

@Service
public interface AdminUsersApiService {

    AdminUsersHttpResponse execute(AdminUsersHttpRequest requset);
}
