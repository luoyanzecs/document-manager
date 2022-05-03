package cn.luoyanze.documentmanager.service.service.impl;

import cn.luoyanze.documentmanager.common.contract.LoginHttpRequest;
import cn.luoyanze.documentmanager.common.contract.LoginHttpResponse;
import cn.luoyanze.documentmanager.common.contract.LoginHttpResponse.User;
import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.common.util.TokenUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.service.LoginApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static cn.luoyanze.documentmanager.common.model.HeadStatus.SUCCESS;
import static cn.luoyanze.documentmanager.common.model.HeadStatus.USER_NOT_EXISIT;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:24 PM
 */

@Service
public class LoginApiServiceImpl implements LoginApiService {

    private final DSLContext dao;

    public LoginApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public LoginHttpResponse execute(LoginHttpRequest requset) throws Exception {

        S1UserBO user = dao.select()
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(requset.getUsername()))
                .and(S1_USER.PASSWORD.eq(requset.getPassword()))
                .and(S1_USER.ROLE.eq(requset.getRole()))
                .limit(1)
                .fetchOneInto(S1UserBO.class);

        LoginHttpResponse resp = new LoginHttpResponse();

        Optional.ofNullable(user)
                .ifPresentOrElse(
                        it -> {
                            resp.setHead(new ResponseHead(SUCCESS));
                            resp.setUser(
                                    new User(
                                            user.getAccount(),
                                            user.getAvatar(),
                                            user.getPrimaryId(),
                                            user.getBuId(),
                                            user.getRole(),
                                            user.getAuthority()
                                    )
                            );
                            resp.setToken(TokenUtil.buildJWT(requset.getUsername()));
                            dao.update(S1_USER)
                                    .set(S1_USER.LAST_LOGIN_TIME, LocalDateTime.now(ZoneId.systemDefault()))
                                    .where(S1_USER.PRIMARY_ID.eq(user.getPrimaryId()))
                                    .execute();
                        },
                        () -> resp.setHead(new ResponseHead(USER_NOT_EXISIT))
                );

        return resp;
    }
}
