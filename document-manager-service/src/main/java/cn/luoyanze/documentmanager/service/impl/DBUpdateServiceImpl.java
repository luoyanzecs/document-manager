package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static cn.luoyanze.common.model.HeadStatus.*;
import static cn.luoyanze.documentmanager.dao.Tables.S1_DOC;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

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




        DeleteAttachHttpResponse resp = new DeleteAttachHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }





    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) {
        DeleteTableItemHttpResponse resp = new DeleteTableItemHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }
}
