package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AdminNoticesHttpRequest;
import cn.luoyanze.common.contract.AdminNoticesHttpResponse;
import cn.luoyanze.common.contract.entity.NoticeInAdmin;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.service.AdminNoticesApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:12 PM
 */
@Service
public class AdminNoticesApiServiceImpl implements AdminNoticesApiService {

    private final DSLContext dao;

    public AdminNoticesApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AdminNoticesHttpResponse execute(AdminNoticesHttpRequest request) {
        int totalPage = dao.fetchCount(S1_NOTICE) / request.getSize();

        List<S1NoticeBO> notices = dao.selectFrom(S1_NOTICE)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .fetchInto(S1NoticeBO.class);

        AdminNoticesHttpResponse resp = new AdminNoticesHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setCurrentPage(request.getPage());
        resp.setTotalPage(totalPage);
        resp.setKeys(List.of("id", "to", "bu", "ctx", "startTime", "endTime"));
        resp.setCols(List.of(2, 2, 2, 7, 4, 4));
        resp.setFields(List.of("编号", "对象", "部门", "内容", "创建时间", "结束时间"));
        resp.setNotices(wrapper(notices));
        return resp;
    }

    private List<NoticeInAdmin> wrapper(List<S1NoticeBO> notices) {
        return notices.stream().map(it -> {
            NoticeInAdmin notice = new NoticeInAdmin();
            notice.setBu(it.getAcceptBu());
            notice.setCtx(it.getContent());
            notice.setTo(it.getAcceptUsers());
            notice.setStartTime(TimeUtil.formatter(it.getStartTime()));
            notice.setEndTime(TimeUtil.formatter(it.getEndTime()));
            notice.setItemId(it.getUuid());
            return notice;
        }).collect(Collectors.toList());
    }
}
