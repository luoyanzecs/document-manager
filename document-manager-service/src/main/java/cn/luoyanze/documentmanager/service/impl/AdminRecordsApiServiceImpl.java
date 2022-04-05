package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AdminNoticesHttpResponse;
import cn.luoyanze.common.contract.AdminRecordsHttpRequset;
import cn.luoyanze.common.contract.AdminRecordsHttpResponse;
import cn.luoyanze.common.contract.entity.NoticeInAdmin;
import cn.luoyanze.common.contract.entity.RecordInAdmin;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1OperateBO;
import cn.luoyanze.documentmanager.service.AdminRecordsApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_NOTICE;
import static cn.luoyanze.documentmanager.dao.Tables.S1_OPERATE;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:12 PM
 */

@Service
public class AdminRecordsApiServiceImpl implements AdminRecordsApiService {

    private final DSLContext dao;

    public AdminRecordsApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AdminRecordsHttpResponse execute(AdminRecordsHttpRequset request) {

        int totalPage = dao.fetchCount(S1_OPERATE) / request.getSize();

        List<S1OperateBO> records = dao.selectFrom(S1_OPERATE)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .fetchInto(S1OperateBO.class);

        AdminRecordsHttpResponse resp = new AdminRecordsHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setCurrentPage(request.getPage());
        resp.setTotalPage(totalPage);
        resp.setKeys(List.of("itemId", "id", "operate", "fid", "oprateTime"));
        resp.setCols(List.of(3, 3, 3, 4, 7));
        resp.setFields(List.of("编号", "用户编号", "操作", "文件编号", "时间"));
        resp.setRecords(wrapper(records));
        return resp;
    }

    private List<RecordInAdmin> wrapper(List<S1OperateBO> records) {
        return records.stream().map(it -> {
            RecordInAdmin record = new RecordInAdmin();
            record.setItemId(it.getPrimaryId() + "");
            record.setUserId(it.getUserUuid());
            record.setOperate(it.getType() + "");
            record.setFid(it.getDocUuid());
            record.setOperateTime(TimeUtil.formatter(it.getTime()));
            return record;
        }).collect(Collectors.toList());
    }
}
