package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.AdminFilesHttpRequest;
import cn.luoyanze.documentmanager.contract.AdminFilesHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:06 PM
 */

public interface AdminFilesApiService {

    AdminFilesHttpResponse execute(AdminFilesHttpRequest request);
}
