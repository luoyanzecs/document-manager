package cn.luoyanze.documentmanager.service.service.impl;

import cn.luoyanze.documentmanager.common.contract.*;
import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1AttachBO;
import cn.luoyanze.documentmanager.dao.tables.records.S1NodeRecord;
import cn.luoyanze.documentmanager.service.exception.CustomException;
import cn.luoyanze.documentmanager.service.model.NodeType;
import cn.luoyanze.documentmanager.service.model.SearchModel;
import cn.luoyanze.documentmanager.service.model.enums.OpraterType;
import cn.luoyanze.documentmanager.service.search.LuceneIndexManager;
import cn.luoyanze.documentmanager.service.service.DBUpdateService;
import com.alibaba.fastjson.JSON;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.luoyanze.documentmanager.common.model.HeadStatus.*;
import static cn.luoyanze.documentmanager.dao.Tables.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 9:55 PM
 */

/**
 * 一些更改操作
 */
@Service
public class DBUpdateServiceImpl implements DBUpdateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUpdateServiceImpl.class);

    private final DSLContext dao;
    private final LuceneIndexManager luceneIndexManager;

    public DBUpdateServiceImpl(DSLContext dao, LuceneIndexManager luceneIndexManager) {
        this.dao = dao;
        this.luceneIndexManager = luceneIndexManager;
    }


    @Override
    public UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request) {
        UpdateFileHttpResponse resp = new UpdateFileHttpResponse();
        try {
            Queue<String> queue = new LinkedList<>(request.getDeleteIds());
            Set<String> deleteIds = new HashSet<>();

            while (!queue.isEmpty()) {
                String poll = queue.poll();
                List<String> ids = dao.select(S1_NODE.UUID).from(S1_NODE).where(S1_NODE.PARENTUUID.eq(poll)).fetchInto(String.class);
                deleteIds.add(poll);
                queue.addAll(ids);
            }

            dao.batchUpdate(
                    Stream.of(
                            request.getUpdateNodes().stream()
                                    .filter(it -> NodeType.TEXT.equalsIgnoreCase(it.getType()))
                                    .map(it -> new S1NodeRecord() {{
                                        setUuid(it.getId());
                                        setText(it.getText());
                                        setHash(it.getText().hashCode() + "");
                                        setHash(it.getHash());
                                        setLastTime(TimeUtil.now());
                                    }}),
                            request.getUpdateNodes().stream()
                                    .filter(it -> NodeType.ELEMENT.equalsIgnoreCase(it.getType()))
                                    .map(it -> new S1NodeRecord() {{
                                        setUuid(it.getId());
                                        setStyle(it.getStyles());
                                        setClass_(it.getClasses());
                                        setAttribute(JSON.toJSONString(it.getAttr()));
                                        setHash(it.getHash());
                                        setLastTime(TimeUtil.now());
                                    }}),
                            deleteIds.stream()
                                    .map(it -> new S1NodeRecord() {{
                                        setUuid(it);
                                        setIsDel(1);
                                        setLastTime(TimeUtil.now());
                                    }})
                    ).flatMap(it -> it).collect(Collectors.toList())
            ).execute();

            luceneIndexManager.deleteByNodeIds(
                    deleteIds.stream().filter(it ->
                        NodeType.TEXT.equalsIgnoreCase(
                                dao.select(S1_NODE.TYPE).from(S1_NODE)
                                        .where(S1_NODE.UUID.eq(it))
                                        .fetchOneInto(String.class)
                        )
                    ).collect(Collectors.toList())
            );

            dao.batchInsert(
                    request.getNewNodes().stream().map(it -> {

                        if (it.getType().equalsIgnoreCase(NodeType.TEXT)) {
                            SearchModel searchModel = new SearchModel();
                            searchModel.setText(it.getText());
                            searchModel.setNodeId(it.getId());
                            searchModel.setFileId(request.getFileId());
                            searchModel.setTitle(
                                    dao.select(S1_DOC.TITLE).from(S1_DOC)
                                            .where(S1_DOC.PRIMARY_ID.eq(request.getFileId()))
                                            .fetchOneInto(String.class)
                            );
                            searchModel.setAuthor(
                                    dao.select(S1_USER.ACCOUNT).from(S1_USER)
                                            .where(S1_USER.PRIMARY_ID.eq(request.getHead().getUserId()))
                                            .fetchOneInto(String.class)
                            );
                            luceneIndexManager.add(searchModel);
                        }

                        return new S1NodeRecord(
                                it.getId(), it.getStyles(), it.getClasses(),
                                JSON.toJSONString(it.getAttr()), it.getTag(),
                                it.getType(), it.getParent(), it.getIndex(), it.getText(),
                                it.getHash(), request.getFileId(), 0, TimeUtil.now()
                        );
                    }).collect(Collectors.toList())
            ).execute();


            resp.setHead(new ResponseHead(SUCCESS));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(UPDATE_FILE_FAIL));
        } finally {
            dao.insertInto(S1_OPERATE)
                    .set(S1_OPERATE.TYPE, OpraterType.UPDATE_FILE.getId())
                    .set(S1_OPERATE.TIME, TimeUtil.now())
                    .set(S1_OPERATE.DOC_ID, request.getFileId())
                    .set(S1_OPERATE.USER_ID, request.getHead().getUserId())
                    .set(S1_OPERATE.CONTENT, "用户名: " + request.getHead().getUsername())
                    .execute();
        }

        return resp;
    }

    /**
     * 删除附件， 只需要把doc数据库的附件链接删除即可
     */
    @Override
    public DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request) {
        DeleteAttachHttpResponse resp = new DeleteAttachHttpResponse();
        try {
            dao.update(S1_ATTACH)
                    .set(S1_ATTACH.ISDEL, 1)
                    .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                    .execute();

            resp.setHead(new ResponseHead(SUCCESS));

            dao.select()
                    .from(S1_ATTACH)
                    .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                    .fetchInto(S1AttachBO.class)
                    .stream().findFirst()
                    .ifPresent(it ->
                            dao.insertInto(S1_OPERATE)
                                    .set(S1_OPERATE.TYPE, OpraterType.DELETE_ATTACH.getId())
                                    .set(S1_OPERATE.TIME, LocalDateTime.now(ZoneId.systemDefault()))
                                    .set(S1_OPERATE.DOC_ID, it.getDocPrimaryId())
                                    .set(S1_OPERATE.CONTENT, "附件名 : " + it.getName())
                                    .set(S1_OPERATE.USER_ID, request.getHead().getUserId())
                                    .execute()
                    );


        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            resp.setHead(new ResponseHead(DELETE_ATTACH_FAIL));
        }

        return resp;
    }


    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) throws CustomException {

        dao.transaction(t -> {
            final DSLContext inner = DSL.using(t);
            Stream<Integer> stream = request.getIds().stream().filter(it -> it > 0);
            switch (request.getMenuIndex()) {
                case 0: // 用户管理
                    stream.forEach(it -> inner.update(S1_USER)
                            .set(S1_USER.ISDEL, 1)
                            .where(S1_USER.PRIMARY_ID.eq(it))
                            .execute()
                    );
                    break;
                case 1: // 记录管理
                    stream.forEach(it -> inner.update(S1_OPERATE)
                            .set(S1_OPERATE.ISDEL, 1)
                            .where(S1_OPERATE.PRIMARY_ID.eq(it))
                            .execute()
                    );
                    break;
                case 2: // 文件管理
                    stream.forEach(it -> inner.update(S1_DOC)
                            .set(S1_DOC.ISDEL, 1)
                            .where(S1_DOC.PRIMARY_ID.eq(it))
                            .execute()
                    );
                    break;
                case 3: // 通知
                    stream.forEach(it -> inner.update(S1_NOTICE)
                            .set(S1_NOTICE.ISDEL, 1)
                            .where(S1_NOTICE.PRIMARY_ID.eq(it))
                            .execute()
                    );
                    break;
                default:
                    throw new CustomException("", MENU_INDEX_ERROR);
            }

        });

        DeleteTableItemHttpResponse resp = new DeleteTableItemHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }
}
