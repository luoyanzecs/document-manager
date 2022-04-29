package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 8:51 PM
 */


public interface DBSelectService {

    FileCommentHttpResponse selectFileComment(FileCommentHttpRequset request);

    FileMenuHttpResponse selectMenuByBu(FileMenuHttpRequset request);

    UserFileHttpResponse selectFileById(UserFileHttpRequset request);

    NoticeHttpResponse selectNotice(NoticeHttpRequset requset);

    GetBuHttpResponse selectAllBu(GetBuHttpRequest request);
}
