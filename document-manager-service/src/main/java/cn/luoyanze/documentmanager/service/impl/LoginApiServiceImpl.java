package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.LoginHttpRequset;
import cn.luoyanze.common.contract.LoginHttpResponse;
import cn.luoyanze.common.contract.LoginHttpResponse.User;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.util.TokenUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.exception.CustomException;
import cn.luoyanze.documentmanager.service.LoginApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import static cn.luoyanze.common.model.HeadStatus.SUCCESS;
import static cn.luoyanze.common.model.HeadStatus.USER_NOT_EXISIT;
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
    public LoginHttpResponse execute(LoginHttpRequset requset) throws Exception {

        S1UserBO user = dao.select()
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(requset.getUsername()))
                .limit(1)
                .fetchOneInto(S1UserBO.class);

        return wrapper(user, requset);
    }

    private LoginHttpResponse wrapper(S1UserBO user, LoginHttpRequset requset) throws CustomException {
        LoginHttpResponse resp = new LoginHttpResponse();

        if (user == null) {
            throw new CustomException("", USER_NOT_EXISIT);
        }

        resp.setHead(new ResponseHead(SUCCESS));
        resp.setUser(
                new User(user.getAccount(), "", user.getPrimaryId(), user.getBuId(), user.getAuthority())
        );
        resp.setToken(TokenUtil.buildJWT(requset.getUsername()));
        return resp;
    }
}
