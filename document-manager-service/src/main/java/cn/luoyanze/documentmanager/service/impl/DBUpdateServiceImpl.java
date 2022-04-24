package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DirBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DocBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request) {
        int execute = 0;
        if (dao.select().from(S1_USER)
                .where(S1_USER.PRIMARY_ID.eq((request.getFileId())))
                .fetchInto(S1UserBO.class).size() ==1 ){
            execute = dao.update(S1_DOC).set(
                            S1_DOC.CTX, request.getJsonValue())
                    .set(S1_DOC.LAST_UPDATE_USER_ID, request.getUserid())
                    .where(S1_DOC.PRIMARY_ID.eq((request.getFileId())))
                    .execute();
        }

        UpdateFileHttpResponse resp = new UpdateFileHttpResponse();
        if (execute == 1) {
            resp.setHead(new ResponseHead(SUCCESS));
        } else {
            resp.setHead(new ResponseHead(UPDATE_FILE_FAIL));
        }
        return resp;
    }

    /**
     * 删除附件， 只需要把doc数据库的附件链接删除即可
     */
    @Override
    public DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request) {
        int execute = 0;
        Record1<Integer> records = dao.select(S1_DOC.PRIMARY_ID)
                .from(S1_DOC)
                .where(S1_DOC.TITLE.eq(request.getDoc_title()))
                .and(S1_DOC.USER_ID.eq(request.getUser_id()))
                .fetchOne();
        if (records!=null){
            Record1<Integer> record1 = dao.select(S1_ATTACH.PRIMARY_ID).from(S1_ATTACH)
                    .where(S1_ATTACH.DOC_PRIMARY_ID.eq(records.get(S1_DOC.PRIMARY_ID)))
                    .and(S1_ATTACH.ISDEL.eq(0)).fetchOne();
            if (record1!=null){
                execute = dao.update(S1_ATTACH)
                        .set(S1_ATTACH.ISDEL,1)
                        .where(S1_ATTACH.PRIMARY_ID.eq(record1.get(S1_USER.PRIMARY_ID))).execute();
            }

        }
        DeleteAttachHttpResponse resp = new DeleteAttachHttpResponse();
        if (execute == 1){
            resp.setHead(new ResponseHead(SUCCESS));
        }
        else{
            resp.setHead(new ResponseHead(DELETE_ATTACH_FAIL));
        }

        return resp;
    }





    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) {
        DeleteTableItemHttpResponse resp = new DeleteTableItemHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }
}
