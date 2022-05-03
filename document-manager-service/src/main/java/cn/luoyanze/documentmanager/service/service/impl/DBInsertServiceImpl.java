package cn.luoyanze.documentmanager.service.service.impl;

import cn.luoyanze.documentmanager.common.contract.*;
import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.records.S1CommentRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1DocRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1NoticeRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1UserRecord;
import cn.luoyanze.documentmanager.service.model.enums.OpraterType;
import cn.luoyanze.documentmanager.service.service.DBInsertService;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.common.model.HeadStatus.*;
import static cn.luoyanze.documentmanager.dao.Tables.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:58 PM
 */

@Service
public class DBInsertServiceImpl implements DBInsertService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBInsertServiceImpl.class);

    private final DSLContext dao;

    public DBInsertServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public CreateFileHttpResponse insertNewFile(CreateFileHttpRequest request) {
        CreateFileHttpResponse resp = new CreateFileHttpResponse();
        try {
            S1DocRecord record = new S1DocRecord();
            record.setLastUpdateUserId(request.getHead().getUserId());
            record.setTitle(request.getTitle());
            record.setPermissionBu(request.getBu());
            record.setDirId(request.getParentId());
            record.setLastUpdateTime(LocalDateTime.now(ZoneId.systemDefault()));
            record.setUserId(request.getHead().getUserId());
            record.setAuthority(0);
            record.setLastUpdateUserId(request.getHead().getUserId());
            record.setPermissionBu("all");

            S1DocRecord res = dao.insertInto(S1_DOC).set(record)
                    .returning(S1_DOC.PRIMARY_ID)
                    .fetchOne();

            Optional.ofNullable(res)
                    .map(S1DocRecord::getPrimaryId)
                    .ifPresentOrElse(
                            it -> {
                                resp.setHead(new ResponseHead(SUCCESS));
                                resp.setFileId(it);

                                dao.insertInto(S1_OPERATE)
                                        .set(S1_OPERATE.TYPE, OpraterType.CREATE_FILE.getId())
                                        .set(S1_OPERATE.TIME, LocalDateTime.now(ZoneId.systemDefault()))
                                        .set(S1_OPERATE.DOC_ID, it)
                                        .set(S1_OPERATE.USER_ID, request.getHead().getUserId())
                                        .set(S1_OPERATE.CONTENT, "文件名 : " + request.getTitle())
                                        .execute();
                            },
                            () -> resp.setHead(new ResponseHead(DOC_CREATE_FAIL))
                    );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(DOC_CREATE_FAIL));
        }
        return resp;
    }

    @Override
    public LeaveMessageHttpResponse insertNewComment(LeaveMessageHttpRequest request) {
        LeaveMessageHttpResponse resp = new LeaveMessageHttpResponse();
        try {
            S1CommentRecord record = new S1CommentRecord();
            record.setCtx(request.getCtx());
            record.setCreateTime(LocalDateTime.now(ZoneId.systemDefault()));
            record.setUserId(request.getHead().getUserId());
            record.setDocId(request.getFileId());
            record.setParentId(Optional.ofNullable(request.getParentCommentId()).orElse(0));

            S1CommentRecord res = dao.insertInto(S1_COMMENT)
                    .set(record)
                    .returning(S1_COMMENT.PRIMARY_ID)
                    .fetchOne();

            Optional.ofNullable(res)
                    .map(S1CommentRecord::getPrimaryId)
                    .ifPresentOrElse(
                            it -> {
                                resp.setHead(new ResponseHead(SUCCESS));
                                resp.setId(it);
                            },
                            () -> resp.setHead(new ResponseHead(INSERT_COMMENT_FAIL))
                    );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(INSERT_COMMENT_FAIL));
        }
        return resp;
    }

    @Override
    public AddNoticeHttpResponse insertNewNotice(AddNoticeHttpRequest request) {
        AddNoticeHttpResponse resp = new AddNoticeHttpResponse();
        try {
            S1NoticeRecord notice = new S1NoticeRecord();
            notice.setContent(request.getText());
            notice.setIsGlobal(request.getType());
            notice.setEndTime(LocalDateTime.ofInstant(request.getExpiredTime().toInstant(), ZoneId.systemDefault()));
            notice.setStartTime(LocalDateTime.ofInstant(request.getStartTime().toInstant(), ZoneId.systemDefault()));
            // 1成功， 2失败 其他普通信息
            notice.setType(request.getType());
            notice.setIsGlobal(request.isGlobal() ? 1 : 0);
            notice.setUserId(request.getHead().getUserId());
            notice.setAcceptBu(request.getBu().stream().map(String::valueOf).collect(Collectors.joining(",")));
            notice.setAcceptUsers(
                    Optional.ofNullable(request.getUsers())
                            .orElse(Collections.emptyList())
                            .stream()
                            .filter(Objects::nonNull)
                            .filter(it -> it > 0)
                            .map(String::valueOf)
                            .collect(Collectors.joining(","))
            );
            dao.insertInto(S1_NOTICE).set(notice).execute();
            resp.setHead(new ResponseHead(SUCCESS));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(INSERT_NOTICE_FAIL));

        }
        return resp;
    }

    @Override
    public AddUserHttpResponse insertNewUser(AddUserHttpRequest request) {
        AddUserHttpResponse resp = new AddUserHttpResponse();
        try {
            S1UserRecord user = new S1UserRecord();
            user.setAccount(request.getName());
            user.setPassword(request.getPassword());
            user.setBuId(request.getBu());
            user.setRole(request.isAdmin() ? "管理员" : "用户");
            user.setAuthority(request.getRank());
            user.setRegisterTime(LocalDateTime.now(ZoneId.systemDefault()));
            user.setStatus(1);
            dao.insertInto(S1_USER).set(user).execute();
            resp.setHead(new ResponseHead(SUCCESS));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(INSERT_USER_FAIL));
        }

        return resp;
    }
}
