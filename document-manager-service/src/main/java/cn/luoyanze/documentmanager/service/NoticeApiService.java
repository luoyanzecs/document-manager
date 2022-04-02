package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.NoticeHttpRequset;
import cn.luoyanze.documentmanager.contract.NoticeHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:25 PM
 */

public interface NoticeApiService {
    NoticeHttpResponse excute(NoticeHttpRequset requset);
}
