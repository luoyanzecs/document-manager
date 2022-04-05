package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.NoticeHttpRequset;
import cn.luoyanze.common.contract.NoticeHttpResponse;
import cn.luoyanze.documentmanager.service.NoticeApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:26 PM
 */

@Service
public class NoticeApiServiceImpl implements NoticeApiService {

    private final DSLContext dao;

    public NoticeApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public NoticeHttpResponse excute(NoticeHttpRequset requset) {
        return null;
    }
}
