package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.FileCommentHttpResponse.Comment;
import cn.luoyanze.common.contract.NoticeHttpResponse.Notice;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.*;
import cn.luoyanze.documentmanager.model.DocVO;
import cn.luoyanze.documentmanager.model.FileComment;
import cn.luoyanze.documentmanager.service.DBSelectService;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record7;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.luoyanze.common.contract.FileMenuHttpResponse.*;
import static cn.luoyanze.common.model.HeadStatus.*;
import static cn.luoyanze.documentmanager.dao.Tables.*;
import static cn.luoyanze.documentmanager.dao.Tables.S1_DOC;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 8:55 PM
 */

@Service
public class DBSelectServiceImpl implements DBSelectService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DBSelectServiceImpl.class);

    private final DSLContext dao;

    public DBSelectServiceImpl(DSLContext dao) {
        this.dao = dao;
    }


    @Override
    public FileCommentHttpResponse selectFileComment(FileCommentHttpRequset request) {
        List<FileComment> comments = dao.select(
                        S1_USER.ACCOUNT.as("username"),
                        S1_USER.PRIMARY_ID.as("userId"),
                        S1_USER.AVATAR.as("avatar"),
                        S1_COMMENT.CTX.as("ctx"),
                        S1_COMMENT.PARENT_ID.as("parentId"),
                        S1_COMMENT.PRIMARY_ID.as("commentId"),
                        S1_COMMENT.CREATE_TIME.as("time")
                ).from(S1_COMMENT)
                .rightJoin(S1_USER)
                .on(S1_COMMENT.USER_ID.eq(S1_USER.PRIMARY_ID))
                .where(S1_COMMENT.DOC_ID.eq(request.getId()))
                .and(S1_COMMENT.PARENT_ID.eq(0))
                .fetchInto(FileComment.class);

        Set<Integer> parents = comments.stream()
                .map(FileComment::getCommentId)
                .collect(Collectors.toSet());

        List<FileComment> replys = dao.select(
                        S1_USER.ACCOUNT.as("username"),
                        S1_USER.PRIMARY_ID.as("userId"),
                        S1_USER.AVATAR.as("avatar"),
                        S1_COMMENT.CTX.as("ctx"),
                        S1_COMMENT.PARENT_ID.as("parentId"),
                        S1_COMMENT.PRIMARY_ID.as("commentId"),
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
        return comments.stream().map(it -> {
            Comment comment = wrapperComment(it);
            comment.setReply(
                    replys.stream()
                            .filter(re -> Objects.equals(re.getParentId(), it.getCommentId()))
                            .sorted(Comparator.comparing(FileComment::getTime))
                            .map(this::wrapperComment)
                            .collect(Collectors.toList())
            );
            return comment;
        }).collect(Collectors.toList());
    }

    private Comment wrapperComment(FileComment it) {
        Comment comment = new Comment();
        comment.setTime(TimeUtil.formatter(it.getTime()));
        comment.setUsername(it.getUsername());
        comment.setAvatar(it.getAvatar());
        comment.setId(it.getCommentId());
        comment.setCtx(it.getCtx());
        comment.setUserId(it.getUserId());
        return comment;
    }

    @Override
    public FileMenuHttpResponse selectMenuByBu(FileMenuHttpRequset request) {
        List<S1DirBO> dirs = dao.selectFrom(S1_DIR).where(S1_DIR.BU_ID.eq(request.getBu())).fetchInto(S1DirBO.class);

        List<DocVO> docVOS = dao.select(S1_DOC.PRIMARY_ID.as("id"),
                        S1_DOC.DIR_ID.as("parentId"),
                        S1_DOC.TITLE.as("title"))
                .from(S1_DOC).fetchInto(DocVO.class);

        FileMenuHttpResponse resp = new FileMenuHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        resp.setMenus(generate(dirs, docVOS));

        return resp;
    }

    private List<Menu> generate(List<S1DirBO> dirs, List<DocVO> docVOS) {

        List<Menu> root = Stream.concat(
                dirs.stream()
                        .filter(it -> it.getParentId() == 1)
                        .map(it -> new Menu(it.getPrimaryId(), it.getTitle(), true, Collections.emptyList()))
                ,
                docVOS.stream()
                        .filter(it -> it.getParentId() == 1)
                        .map(it -> new Menu(it.getId(), it.getTitle(), false, Collections.emptyList()))
        ).collect(Collectors.toList());

        List<S1DirBO> subDirNodes;
        List<Menu> parents = root.stream().filter(Menu::isDir).collect(Collectors.toList());
        do {
            Set<Integer> parentsId = parents.stream().filter(Menu::isDir).map(Menu::getId).collect(Collectors.toSet());
            // 获取所有的subs节点
            subDirNodes = dirs.stream()
                    .filter(it -> parentsId.contains(it.getParentId()))
                    .collect(Collectors.toList());

            List<Menu> nextLoopParents = new ArrayList<>();
            for (Menu parent : parents) {
                // 获取sub节点, 目录节点
                List<Menu> subNodeInEachParent =
                        subDirNodes.stream().filter(o -> parent.getId() == o.getParentId().intValue())
                                .map(it -> new Menu(it.getPrimaryId(), it.getTitle(), true, Collections.emptyList()))
                                .collect(Collectors.toList());

                nextLoopParents.addAll(subNodeInEachParent);

                subNodeInEachParent.addAll(
                        docVOS.stream().filter(it -> it.getParentId().equals(parent.getId()))
                                .map(it -> new Menu(it.getId(), it.getTitle(), false, Collections.emptyList()))
                                .collect(Collectors.toList())
                );
                parent.setSubs(subNodeInEachParent);
            }

            parents = nextLoopParents;
        } while (!subDirNodes.isEmpty());

        return root;
    }

    @Override
    public UserFileHttpResponse selectFileById(UserFileHttpRequset request) {
        UserFileHttpResponse resp = new UserFileHttpResponse();
        try {
            S1DocBO doc = dao.select().from(S1_DOC)
                    .where(S1_DOC.PRIMARY_ID.eq(request.getId()))
                    .and(S1_DOC.ISDEL.eq(0))
                    .fetchOneInto(S1DocBO.class);

            S1UserBO user = dao.select()
                    .from(S1_USER)
                    .where(S1_USER.PRIMARY_ID.eq(request.getHead().getUserId()))
                    .fetchOneInto(S1UserBO.class);

            if (doc == null || user == null || doc.getAuthority() > user.getAuthority()) {
                resp.setHead(new ResponseHead(FORBBIDEN));
                return resp;
            }

            String editorName = dao.select(S1_USER.ACCOUNT)
                    .from(S1_USER)
                    .where(S1_USER.PRIMARY_ID.eq(doc.getUserId()))
                    .fetchOneInto(String.class);

            List<UserFileHttpResponse.Attach> attaches = dao.select().from(S1_ATTACH)
                    .where(S1_ATTACH.DOC_PRIMARY_ID.eq(request.getId()))
                    .and(S1_ATTACH.ISDEL.eq(0))
                    .fetchInto(UserFileHttpResponse.Attach.class);

            resp.setHead(new ResponseHead(SUCCESS));
            resp.setFile(new UserFileHttpResponse.File(editorName, TimeUtil.formatter(doc.getLastUpdateTime()), doc.getCtx(), attaches));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(FILE_SELECT_ERROR));
        }
        return resp;
    }

    @Override
    public NoticeHttpResponse selectNotice(NoticeHttpRequset requset) {
        NoticeHttpResponse resp = new NoticeHttpResponse();
        LocalDateTime now = LocalDateTime.now();
        Record2<Integer, Integer> user = dao.select(S1_USER.PRIMARY_ID, S1_USER.BU_ID)
                .from(S1_USER)
                .where(S1_USER.PRIMARY_ID.eq(requset.getHead().getUserId()))
                .fetchOne();
        if (user == null) {
            resp.setHead(new ResponseHead(USER_NOT_EXISIT));
            return resp;
        }

        List<S1NoticeBO> records = dao.select().from(S1_NOTICE)
                .where(S1_NOTICE.START_TIME.compare(org.jooq.Comparator.LESS, now))
                .and(S1_NOTICE.END_TIME.compare(org.jooq.Comparator.GREATER, now))
                .fetchInto(S1NoticeBO.class);

        List<Notice> notices = records.stream()
                .filter(it -> it.getAcceptUsers().contains(user.get(S1_USER.PRIMARY_ID).toString())
                        && it.getAcceptBu().contains(user.get(S1_USER.BU_ID).toString())
                )
                .map(it -> new Notice(it.getPrimaryId(), it.getType(), it.getContent()))
                .collect(Collectors.toList());


        resp.setHead(new ResponseHead(SUCCESS));
        resp.setNotices(notices);
        return resp;
    }

    @Override
    public GetBuHttpResponse selectAllBu(GetBuHttpRequest request) {
        List<S1BuBO> bus = dao.select().from(S1_BU).fetchInto(S1BuBO.class);
        return new GetBuHttpResponse() {{
            setHead(new ResponseHead(SUCCESS));
            setBuList(bus.stream()
                    .map(it ->
                            new GetBuHttpResponse.Bu(it.getPrimaryId(), it.getName())
                    ).collect(Collectors.toList())
            );
        }};
    }
}
