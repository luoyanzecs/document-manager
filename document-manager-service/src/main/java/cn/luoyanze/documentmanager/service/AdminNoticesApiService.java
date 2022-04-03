package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.AdminNoticesHttpRequest;
import cn.luoyanze.common.contract.AdminNoticesHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:07 PM
 */

public interface AdminNoticesApiService {

    AdminNoticesHttpResponse execute(AdminNoticesHttpRequest request);
}
