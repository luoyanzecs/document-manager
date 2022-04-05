package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.AdminFilesHttpRequest;
import cn.luoyanze.common.contract.AdminFilesHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:06 PM
 */

public interface AdminFilesApiService {

    AdminFilesHttpResponse execute(AdminFilesHttpRequest request);
}
