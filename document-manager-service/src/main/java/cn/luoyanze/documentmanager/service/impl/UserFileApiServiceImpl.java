package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.UserFileHttpRequset;
import cn.luoyanze.common.contract.UserFileHttpResponse;
import cn.luoyanze.common.contract.entity.File;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DocBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.UserFileApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static cn.luoyanze.common.model.HeadStatus.FORBBIDEN;
import static cn.luoyanze.common.model.HeadStatus.SUCCESS;
import static cn.luoyanze.documentmanager.dao.Tables.S1_DOC;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:21 PM
 */
@Service
public class UserFileApiServiceImpl implements UserFileApiService {

    private final DSLContext dao;

    public UserFileApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public UserFileHttpResponse excute(UserFileHttpRequset requset) {
        S1DocBO doc = dao.select().from(S1_DOC)
                .where(S1_DOC.UUID.eq(requset.getId()))
                .fetchOneInto(S1DocBO.class);

        S1UserBO user = dao.select()
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(requset.getHead().getUsername()))
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
        resp.setFile(new File(editorName, TimeUtil.formatter(doc.getLastUpdateTime()), doc.getCtx()));
        return resp;
    }
}
