package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.AdminRecordsHttpRequset;
import cn.luoyanze.documentmanager.contract.AdminRecordsHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:08 PM
 */

@Service
public interface AdminRecordsApiService {

    AdminRecordsHttpResponse execute(AdminRecordsHttpRequset requset);
}
