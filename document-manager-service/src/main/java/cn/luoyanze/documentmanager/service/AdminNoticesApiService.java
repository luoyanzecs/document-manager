package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.AdminNoticesHttpRequest;
import cn.luoyanze.documentmanager.contract.AdminNoticesHttpResponse;
import cn.luoyanze.documentmanager.contract.AdminUsersHttpRequest;
import cn.luoyanze.documentmanager.contract.AdminUsersHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:07 PM
 */

public interface AdminNoticesApiService {

    AdminNoticesHttpResponse execute(AdminNoticesHttpRequest request);
}
