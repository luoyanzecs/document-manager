package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.exception.CustomException;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUpdateServiceImpl.class);

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
        DeleteAttachHttpResponse resp = new DeleteAttachHttpResponse();
        try {
            dao.update(S1_ATTACH)
                    .set(S1_ATTACH.ISDEL, 1)
                    .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                    .execute();

            resp.setHead(new ResponseHead(SUCCESS));

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
                    );break;
                case 1: // 记录管理
                    stream.forEach(it -> inner.update(S1_OPERATE)
                            .set(S1_OPERATE.ISDEL, 1)
                            .where(S1_OPERATE.PRIMARY_ID.eq(it))
                            .execute()
                    );break;
                case 2: // 文件管理
                    stream.forEach(it -> inner.update(S1_DOC)
                            .set(S1_DOC.ISDEL, 1)
                            .where(S1_DOC.PRIMARY_ID.eq(it))
                            .execute()
                    );break;
                case 3: // 通知
                    stream.forEach(it -> inner.update(S1_NOTICE)
                            .set(S1_NOTICE.ISDEL, 1)
                            .where(S1_NOTICE.PRIMARY_ID.eq(it))
                            .execute()
                    );break;
                default:
                    throw new CustomException("", MENU_INDEX_ERROR);
            }

        });

        DeleteTableItemHttpResponse resp = new DeleteTableItemHttpResponse();
        resp.setHead(new ResponseHead(SUCCESS));
        return resp;
    }
}
