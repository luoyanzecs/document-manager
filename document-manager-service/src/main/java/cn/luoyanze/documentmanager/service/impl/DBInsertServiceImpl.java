package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1CommentBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.DBInsertService;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.luoyanze.common.model.HeadStatus.*;
import static cn.luoyanze.documentmanager.dao.Tables.*;

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

        S1CommentBO comment = new S1CommentBO();
        comment.setCtx(request.getCtx());
        comment.setCreateTime(LocalDateTime.now());
        comment.setUserId(UInteger.valueOf(request.getUserId()));
        comment.setDocId(UInteger.valueOf(request.getFileId()));
        comment.setParentId(UInteger.valueOf(request.getParentCommentId()));
        int execute = dao.insertInto(S1_COMMENT).values(comment).execute();

        LeaveMessageHttpResponse resp = new LeaveMessageHttpResponse();

        if (execute == 1) {
            resp.setHead(new ResponseHead(SUCCESS));
        } else {
            resp.setHead(new ResponseHead(INSERT_COMMENT_FAIL));
        }
        return resp;
    }

    @Override
    public AddNoticeHttpResponse insertNewNotice(AddNoticeHttpRequest request) {
        S1NoticeBO notice = new S1NoticeBO();
        notice.setContent(request.getText());
        notice.setIsGlobal(request.getType());
        notice.setEndTime(request.getExpiredTime());
        notice.setStartTime(request.getStartTime());
        notice.setAcceptBu(String.join(",", request.getBu()));
        notice.setAcceptUsers(
                request.getUsers().stream()
                        .filter(Objects::nonNull)
                        .filter(it -> it > 0)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
        );
        int execute = dao.insertInto(S1_NOTICE).values(notice).execute();
        AddNoticeHttpResponse resp = new AddNoticeHttpResponse();
        if (execute == 1) {
            resp.setHead(new ResponseHead(SUCCESS));
        } else {
            resp.setHead(new ResponseHead(INSERT_NOTICE_FAIL));
        }
        return resp;
    }

    @Override
    public AddUserHttpResponse insertNewUser(AddUserHttpRequest request) {
        S1UserBO user = new S1UserBO();
        user.setAccount(request.getName());
        user.setPassword(request.getPassword());
        user.setBu(request.getBu());
        user.setRole(request.isAdmin() ? "管理员" : "用户");
        user.setAuthority(request.getRank());
        user.setRegisterTime(LocalDateTime.now());
        user.setStatus(1);
        int execute = dao.insertInto(S1_USER).values(user).execute();

        AddUserHttpResponse resp = new AddUserHttpResponse();
        if (execute == 1) {
            resp.setHead(new ResponseHead(SUCCESS));
        } else {
            resp.setHead(new ResponseHead(INSERT_NOTICE_FAIL));
        }
        return resp;
    }
}
