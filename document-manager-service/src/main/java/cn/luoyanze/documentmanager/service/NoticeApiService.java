package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.NoticeHttpRequset;
import cn.luoyanze.common.contract.NoticeHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:25 PM
 */

public interface NoticeApiService {
    NoticeHttpResponse excute(NoticeHttpRequset requset);
}
