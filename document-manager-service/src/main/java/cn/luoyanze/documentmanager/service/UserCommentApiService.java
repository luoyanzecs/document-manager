package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.UserCommentHttpRequset;
import cn.luoyanze.documentmanager.contract.UserCommentHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:19 PM
 */

@Service
public interface UserCommentApiService {

    UserCommentHttpResponse excute(UserCommentHttpRequset requset);
}
