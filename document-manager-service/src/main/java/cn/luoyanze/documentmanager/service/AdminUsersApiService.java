package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.AdminUsersHttpRequest;
import cn.luoyanze.common.contract.AdminUsersHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:04 PM
 */

public interface AdminUsersApiService {

    AdminUsersHttpResponse execute(AdminUsersHttpRequest requset);
}
