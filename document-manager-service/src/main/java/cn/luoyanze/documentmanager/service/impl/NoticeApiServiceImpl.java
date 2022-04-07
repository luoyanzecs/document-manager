package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.NoticeHttpRequset;
import cn.luoyanze.common.contract.NoticeHttpResponse;
import cn.luoyanze.common.contract.entity.Notice;
import cn.luoyanze.common.contract.entity.NoticeInAdmin;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.service.NoticeApiService;
import org.jooq.Comparator;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_NOTICE;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

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
        LocalDateTime now = LocalDateTime.now();
        Record2<UInteger, String> user = dao.select(S1_USER.PRIMARY_ID, S1_USER.BU)
                .from(S1_USER)
                .where(S1_USER.ACCOUNT.eq(requset.getHead().getUsername()))
                .fetchOne();

        List<S1NoticeBO> records = dao.select().from(S1_NOTICE)
                .where(S1_NOTICE.START_TIME.compare(Comparator.LESS, now))
                .and(S1_NOTICE.END_TIME.compare(Comparator.GREATER, now))
                .fetchInto(S1NoticeBO.class);

        List<Notice> notices = records.stream()
                .filter(it -> it.getAcceptUsers().contains(user.get(0) + "")
                        && it.getAcceptBu().contains(user.get(1, String.class))
                )
                .map(it -> new Notice(it.getUuid(), it.getType(), it.getContent()))
                .collect(Collectors.toList());

        NoticeHttpResponse resp = new NoticeHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setNotices(notices);

        return resp;
    }
}
