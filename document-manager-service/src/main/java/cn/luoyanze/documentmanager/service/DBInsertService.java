package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:02 PM
 */

public interface DBInsertService {

    CreateFileHttpResponse insertNewFile(CreateFileHttpRequest request);

    LeaveMessageHttpResponse insertNewComment(LeaveMessageHttpRequest request);

    AddNoticeHttpResponse insertNewNotice(AddNoticeHttpRequest request);

    AddUserHttpResponse insertNewUser(AddUserHttpRequest request);
}
