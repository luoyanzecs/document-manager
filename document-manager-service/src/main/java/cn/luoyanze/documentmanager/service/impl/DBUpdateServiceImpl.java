package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.records.S1DocRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1NoticeRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1OperateRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1UserRecord;
import cn.luoyanze.documentmanager.exception.CustomException;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static cn.luoyanze.common.model.HeadStatus.*;
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

    private final DSLContext dao;


    public DBUpdateServiceImpl(DSLContext dao) {
        this.dao = dao;
    }


    @Override
    public UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request) throws CustomException {

        int execute = dao.update(S1_DOC)
                .set(S1_DOC.LAST_UPDATE_USER_ID, request.getHead().getUserId())
                .set(S1_DOC.CTX, request.getJsonValue())
                .set(S1_DOC.LAST_UPDATE_TIME, LocalDateTime.now())
                .where(S1_DOC.PRIMARY_ID.eq(request.getFileId()))
                .execute();


        //if (dao.select().from(S1_USER)
        //        .where(S1_USER.PRIMARY_ID.eq((request.getFileId())))
        //        .fetchInto(S1UserBO.class).size() == 1) {
        //    execute = dao.update(S1_DOC).set(
        //                    S1_DOC.CTX, request.getJsonValue())
        //            .set(S1_DOC.LAST_UPDATE_USER_ID, request.getUserid())
        //            .where(S1_DOC.PRIMARY_ID.eq((request.getFileId())))
        //            .execute();
        //}

        UpdateFileHttpResponse resp = new UpdateFileHttpResponse();
        if (execute == 0) {
            throw new CustomException("", UPDATE_FILE_FAIL);
        }
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }

    /**
     * 删除附件， 只需要把doc数据库的附件链接删除即可
     */
    @Override
    public DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request) throws CustomException {

        int execute = dao.update(S1_ATTACH)
                .set(S1_ATTACH.ISDEL, 1)
                .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                .and(S1_ATTACH.DOC_PRIMARY_ID.eq(request.getDocId()))
                .and(S1_ATTACH.USER_PRIMARY_ID.eq(request.getHead().getUserId()))
                .execute();

        if (execute == 0) {
            throw new CustomException("", DELETE_ATTACH_FAIL);
        }
        DeleteAttachHttpResponse resp = new DeleteAttachHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;

        //Integer docId = dao.select(S1_DOC.PRIMARY_ID)
        //        .from(S1_DOC)
        //        .where(S1_DOC.TITLE.eq(request.getDoc_title()))
        //        .and(S1_DOC.USER_ID.eq(request.getUser_id()))
        //        .fetchOneInto(Integer.class);
        //
        //if (docId == null) {
        //    throw new CustomException("", DELETE_ATTACH_FAIL);
        //}
        //
        //Integer attachId = dao.select(S1_ATTACH.PRIMARY_ID).from(S1_ATTACH)
        //        .where(S1_ATTACH.DOC_PRIMARY_ID.eq(docId))
        //        .and(S1_ATTACH.ISDEL.eq(0))
        //        .fetchOneInto(Integer.class);
        //
        //if (attachId == null) {
        //    throw new CustomException("", DELETE_ATTACH_FAIL);
        //}
        //
        //int execute = dao.update(S1_ATTACH)
        //        .set(S1_ATTACH.ISDEL, 1)
        //        .where(S1_ATTACH.PRIMARY_ID.eq(attachId))
        //        .execute();
        //
    }


    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) throws CustomException {

        int[] execute;
        switch (request.getMenuIndex()) {
            case 0: // 用户管理
                execute = dao.batchDelete(request.getIds().stream()
                        .map(it -> new S1UserRecord() {{
                            setPrimaryId(it);
                        }}).collect(Collectors.toSet())
                ).execute();
                break;
            case 1: // 记录管理
                execute = dao.batchDelete(request.getIds().stream()
                        .map(it -> new S1OperateRecord() {{
                            setPrimaryId(it);
                        }}).collect(Collectors.toSet())
                ).execute();
                break;
            case 2: // 文件管理
                execute = dao.batchDelete(request.getIds().stream()
                        .map(it -> new S1DocRecord() {{
                            setPrimaryId(it);
                        }}).collect(Collectors.toSet())
                ).execute();
                break;
            case 3: // 通知
                execute = dao.batchDelete(request.getIds().stream()
                        .map(it -> new S1NoticeRecord() {{
                            setPrimaryId(it);
                        }}).collect(Collectors.toSet())
                ).execute();
                break;
            default:
                throw new CustomException("", MENU_INDEX_ERROR);
        }

        DeleteTableItemHttpResponse resp = new DeleteTableItemHttpResponse();

        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }
}
