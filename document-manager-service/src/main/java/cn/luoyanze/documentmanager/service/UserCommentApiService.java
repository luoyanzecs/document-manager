package cn.luoyanze.documentmanager.service;

import cn.luoyanze.documentmanager.contract.FileCommentHttpRequset;
import cn.luoyanze.documentmanager.contract.FileCommentHttpResponse;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:19 PM
 */

@Service
public interface UserCommentApiService {

    FileCommentHttpResponse excute(FileCommentHttpRequset requset);
}
