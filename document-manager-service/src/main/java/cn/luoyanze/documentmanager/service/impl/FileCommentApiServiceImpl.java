package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.FileCommentHttpRequset;
import cn.luoyanze.common.contract.FileCommentHttpResponse;
import cn.luoyanze.common.contract.entity.Comment;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1CommentBO;
import cn.luoyanze.documentmanager.model.FileComment;
import cn.luoyanze.documentmanager.service.FileCommentApiService;
import org.jooq.*;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.luoyanze.common.model.HeadStatus.FILE_NOT_EXISIT;
import static cn.luoyanze.common.model.HeadStatus.SUCCESS;
import static cn.luoyanze.documentmanager.dao.Tables.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:20 PM
 */
@Service
public class FileCommentApiServiceImpl implements FileCommentApiService {

    private final DSLContext dao;

    public FileCommentApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public FileCommentHttpResponse excute(FileCommentHttpRequset requset) {

        List<FileComment> comments = dao.select(
                        S1_USER.ACCOUNT.as("username"),
                        S1_USER.UUID.as("userId"),
                        S1_USER.AVATAR.as("avatar"),
                        S1_COMMENT.CTX.as("ctx"),
                        S1_COMMENT.PARENT_ID.as("parentId"),
                        S1_COMMENT.PRIMARY_ID.as("commentPrimaryId"),
                        S1_COMMENT.UUID.as("commentUUID"),
                        S1_COMMENT.CREATE_TIME.as("time")
                ).from(S1_COMMENT)
                .rightJoin(S1_USER)
                .on(S1_COMMENT.USER_ID.eq(S1_USER.PRIMARY_ID))
                .where(S1_COMMENT.UUID.eq(requset.getId()))
                .fetchInto(FileComment.class);

        Set<Integer> parents = comments.stream().map(FileComment::getCommentPrimaryId).collect(Collectors.toSet());

        List<FileComment> replys = dao.select(
                        S1_USER.ACCOUNT.as("username"),
                        S1_USER.UUID.as("userId"),
                        S1_USER.AVATAR.as("avatar"),
                        S1_COMMENT.CTX.as("ctx"),
                        S1_COMMENT.PARENT_ID.as("parentId"),
                        S1_COMMENT.PRIMARY_ID.as("commentPrimaryId"),
                        S1_COMMENT.UUID.as("commentUUID"),
                        S1_COMMENT.CREATE_TIME.as("time")
                ).from(S1_COMMENT)
                .rightJoin(S1_USER)
                .on(S1_COMMENT.USER_ID.eq(S1_USER.PRIMARY_ID))
                .where(S1_COMMENT.PARENT_ID.in(parents))
                .fetchInto(FileComment.class);


        FileCommentHttpResponse resp = new FileCommentHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        resp.setComments(wrapper(comments, replys));
        return resp;
    }

    private List<Comment> wrapper(List<FileComment> comments, List<FileComment> replys) {
        ArrayList<Comment> res = new ArrayList<>();
        comments.forEach(it -> {
            Comment comment = new Comment();
            comment.setTime(TimeUtil.formatter(it.getTime()));
            comment.setUsername(it.getUsername());
            comment.setAvatar(it.getAvatar());
            comment.setId(it.getCommentUUID());
            comment.setCtx(it.getCtx());
            comment.setUsername(it.getUserId());
            comment.setReply(
                    replys.stream()
                            .filter(re -> re.getParentId() == it.getCommentPrimaryId())
                            .sorted(Comparator.comparing(FileComment::getTime))
                            .map(re -> {
                                Comment reply = new Comment();
                                reply.setTime(TimeUtil.formatter(re.getTime()));
                                reply.setUsername(re.getUsername());
                                reply.setAvatar(re.getAvatar());
                                reply.setId(re.getCommentUUID());
                                reply.setCtx(re.getCtx());
                                reply.setUsername(re.getUserId());
                                return reply;
                            }).collect(Collectors.toList())
            );
            res.add(comment);
        });
        return res;
    }
}
