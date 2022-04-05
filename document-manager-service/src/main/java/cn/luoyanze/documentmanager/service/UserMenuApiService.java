package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.FileMenuHttpRequset;
import cn.luoyanze.common.contract.FileMenuHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:17 PM
 */

public interface UserMenuApiService {

    FileMenuHttpResponse excute(FileMenuHttpRequset requset);
}
