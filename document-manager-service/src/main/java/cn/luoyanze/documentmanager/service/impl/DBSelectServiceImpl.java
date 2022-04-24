package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.FileCommentHttpResponse.Comment;
import cn.luoyanze.common.contract.NoticeHttpResponse.Notice;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DirBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DocBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.model.DocVO;
import cn.luoyanze.documentmanager.model.FileComment;
import cn.luoyanze.documentmanager.service.DBSelectService;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
                .where(S1_COMMENT.PRIMARY_ID.eq(request.getId()))
                .fetchInto(FileComment.class);

        Set<Integer> parents = comments.stream().map(FileComment::getCommentId).collect(Collectors.toSet());

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
        List<S1DirBO> dirs = dao.selectFrom(S1_DIR).where(S1_DIR.BU.eq(request.getBu())).fetchInto(S1DirBO.class);

        List<DocVO> docVOS = dao.select().from(S1_DOC).fetchInto(DocVO.class);

        FileMenuHttpResponse resp = new FileMenuHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        resp.setMenus(generate(dirs, docVOS));

        return resp;
    }

    private List<Menu> generate(List<S1DirBO> dirs, List<DocVO> docVOS) {

        List<Menu> root = dirs.stream()
                .filter(it -> it.getParentId() == 0)
                .map(it -> new Menu(it.getPrimaryId(), it.getTitle(), true, new ArrayList<>()))
                .collect(Collectors.toList());
        List<S1DirBO> subDirNodes;
        List<Menu> parents = root;
        do {
            Set<Integer> parentsId = parents.stream().map(Menu::getId).collect(Collectors.toSet());
            // 获取所有的subs节点
            subDirNodes = dirs.stream()
                    .filter(it -> parentsId.contains(it.getParentId()))
                    .collect(Collectors.toList());

            List<Menu> nextLoopParents = new ArrayList<>();
            for (Menu parent : parents) {
                // 获取sub节点, 目录节点
                List<Menu> subNodeInEachParent =
                        subDirNodes.stream().filter(o -> parent.getId() == o.getParentId().intValue())
                                .map(it -> new Menu(it.getPrimaryId(), it.getTitle(), true, new ArrayList<>()))
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
        S1DocBO doc = dao.select().from(S1_DOC)
                .where(S1_DOC.PRIMARY_ID.eq(request.getId()))
                .fetchOneInto(S1DocBO.class);

        S1UserBO user = dao.select()
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(request.getHead().getUsername()))
                .fetchOneInto(S1UserBO.class);

        UserFileHttpResponse resp = new UserFileHttpResponse();

        if (doc == null || user == null || doc.getAuthority() > user.getAuthority()) {
            resp.setHead(new ResponseHead(FORBBIDEN));
            return resp;
        }

        String editorName = dao.select(S1_USER.ACCOUNT)
                .from(S1_USER)
                .where(S1_USER.PRIMARY_ID.eq(doc.getUserId()))
                .fetchOneInto(String.class);

        resp.setHead(new ResponseHead(SUCCESS));
        resp.setFile(new UserFileHttpResponse.File(editorName, TimeUtil.formatter(doc.getLastUpdateTime()), doc.getCtx()));
        return resp;
    }

    @Override
    public NoticeHttpResponse selectNotice(NoticeHttpRequset requset) {
        NoticeHttpResponse resp = new NoticeHttpResponse();
        LocalDateTime now = LocalDateTime.now();
        Record2<Integer, String> user = dao.select(S1_USER.PRIMARY_ID, S1_USER.BU)
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(requset.getHead().getUsername()))
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
                        && it.getAcceptBu().contains(user.get(S1_USER.BU))
                )
                .map(it -> new Notice(it.getPrimaryId(), it.getType(), it.getContent()))
                .collect(Collectors.toList());


        resp.setHead(new ResponseHead(SUCCESS));
        resp.setNotices(notices);
        return resp;
    }

    @Override
    public GetBuHttpResponse selectAllBu(GetBuHttpRequest request) {
        List<String> bus = dao.select(S1_BU.NAME).from(S1_BU).fetchInto(String.class);
        return new GetBuHttpResponse() {{
            setHead(new ResponseHead(SUCCESS));
            setBuList(bus);
        }};
    }
}
