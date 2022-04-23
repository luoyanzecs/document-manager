package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.service.DBInsertService;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:58 PM
 */

@Service
public class DBInsertServiceImpl implements DBInsertService {

    @Override
    public CreateFileHttpResponse insertNewFile(CreateFileHttpRequest request) {
        return null;
    }

    @Override
    public LeaveMessageHttpResponse insertNewComment(LeaveMessageHttpRequest request) {
        return null;
    }

    @Override
    public AddNoticeHttpResponse insertNewNotice(AddNoticeHttpRequest request) {
        return null;
    }

    @Override
    public AddUserHttpResponse insertNewUser(AddUserHttpRequest request) {
        return null;
    }
}
