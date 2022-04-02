package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.FileMenuHttpRequset;
import cn.luoyanze.documentmanager.contract.FileMenuHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:17 PM
 */

public interface UserMenuApiService {

    FileMenuHttpResponse excute(FileMenuHttpRequset requset);
}
