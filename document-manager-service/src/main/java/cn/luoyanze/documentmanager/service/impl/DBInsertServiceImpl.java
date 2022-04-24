package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1CommentBO;
import cn.luoyanze.documentmanager.service.DBInsertService;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static cn.luoyanze.documentmanager.dao.Tables.S1_COMMENT;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:58 PM
 */

@Service
public class DBInsertServiceImpl implements DBInsertService {

    private final DSLContext dao;

    public DBInsertServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public CreateFileHttpResponse insertNewFile(CreateFileHttpRequest request) {
        return null;
    }

    @Override
    public LeaveMessageHttpResponse insertNewComment(LeaveMessageHttpRequest request) {
        //UInteger userId = dao.select(S1_USER.PRIMARY_ID)
        //        .from(S1_USER)
        //        .where(S1_USER.PRIMARY_ID.eq(request.getUserId()))
        //        .fetchOneInto(UInteger.class);

        S1CommentBO comment = new S1CommentBO();
        comment.setCtx(request.getCtx());
        comment.setCreateTime(LocalDateTime.now());
        //comment.setUserId(userId);
        dao.insertInto(S1_COMMENT);
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
