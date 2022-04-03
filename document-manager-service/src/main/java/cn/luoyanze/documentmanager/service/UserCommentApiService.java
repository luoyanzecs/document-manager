package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.FileCommentHttpRequset;
import cn.luoyanze.common.contract.FileCommentHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:19 PM
 */

public interface UserCommentApiService {

    FileCommentHttpResponse excute(FileCommentHttpRequset requset);
}
