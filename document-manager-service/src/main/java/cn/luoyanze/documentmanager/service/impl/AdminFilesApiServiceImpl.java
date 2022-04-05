package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AdminFilesHttpRequest;
import cn.luoyanze.common.contract.AdminFilesHttpResponse;
import cn.luoyanze.common.contract.entity.FileInAdmin;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DocBO;
import cn.luoyanze.documentmanager.service.AdminFilesApiService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_DOC;
import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;
import static org.jooq.impl.DSL.count;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:11 PM
 */
@Service
public class AdminFilesApiServiceImpl implements AdminFilesApiService {

    private final DSLContext dao;

    public AdminFilesApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AdminFilesHttpResponse execute(AdminFilesHttpRequest request) {

        int totalPage = dao.fetchCount(S1_DOC) / request.getSize();

        Result<Record6<String, String, String, String, LocalDateTime, String>> docs
                = dao.select(
                        S1_USER.ACCOUNT,
                        S1_USER.UUID,
                        S1_DOC.UUID,
                        S1_DOC.PERMISSION_BU,
                        S1_DOC.LAST_UPDATE_TIME,
                        S1_DOC.TITLE
                ).from(S1_DOC)
                .rightJoin(S1_USER)
                .on(S1_DOC.USER_ID.eq(S1_USER.PRIMARY_ID))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .fetch();

        AdminFilesHttpResponse resp = new AdminFilesHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setCurrentPage(request.getPage());
        resp.setTotalPage(totalPage);
        resp.setKeys(List.of("id", "owner", "bu", "title", "createTime"));
        resp.setCols(List.of(2, 2, 2, 8, 4));
        resp.setFields(List.of("编号", "作者", "部门", "标题", "创建时间"));
        resp.setFiles(wrapper(docs));
        return resp;
    }

    private List<FileInAdmin> wrapper(Result<Record6<String, String, String, String, LocalDateTime, String>> docs) {
        return docs.stream().map(it -> {
            FileInAdmin file = new FileInAdmin();
            file.setOwner(it.get(0, String.class));
            file.setUserId(it.get(1, String.class));
            file.setFileId(it.get(2, String.class));
            file.setBu(it.get(3, String.class));
            file.setTime(TimeUtil.formatter(it.get(4, LocalDateTime.class)));
            file.setTitle(it.get(5, String.class));
            return file;
        }).collect(Collectors.toList());
    }
}
