package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AdminUsersHttpRequest;
import cn.luoyanze.common.contract.AdminUsersHttpResponse;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.contract.entity.UserInAdmin;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.AdminUsersApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:13 PM
 */

@Service
public class AdminUsersApiServiceImpl implements AdminUsersApiService {

    private final DSLContext dao;

    public AdminUsersApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AdminUsersHttpResponse execute(AdminUsersHttpRequest request) {
        int totalPage = dao.fetchCount(S1_USER) / request.getSize();

        List<S1UserBO> users = dao.selectFrom(S1_USER)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .fetchInto(S1UserBO.class);

        AdminUsersHttpResponse resp = new AdminUsersHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setCurrentPage(request.getPage());
        resp.setTotalPage(totalPage);
        resp.setKeys(List.of("id", "name", "bu", "tel"));
        resp.setCols(List.of(4, 4, 4, 4));
        resp.setFields(List.of("编号", "姓名", "部门", "联系方式"));
        resp.setUsers(wrapper(users));
        return resp;
    }

    private List<UserInAdmin> wrapper(List<S1UserBO> users) {
        return users.stream().map(it -> {
            UserInAdmin user = new UserInAdmin();
            user.setItemId(it.getUuid());
            user.setName(it.getAccount());
            user.setBu(it.getBu());
            user.setTel(it.getTel());
            return user;
        }).collect(Collectors.toList());
    }
}
