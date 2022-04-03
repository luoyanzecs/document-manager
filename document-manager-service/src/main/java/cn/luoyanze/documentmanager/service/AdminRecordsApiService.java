package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.AdminRecordsHttpRequset;
import cn.luoyanze.common.contract.AdminRecordsHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:08 PM
 */

public interface AdminRecordsApiService {

    AdminRecordsHttpResponse execute(AdminRecordsHttpRequset requset);
}
