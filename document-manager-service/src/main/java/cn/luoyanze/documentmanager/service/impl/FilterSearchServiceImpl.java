package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.FilterSearchHttpRequest;
import cn.luoyanze.common.contract.FilterSearchHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.contract.entity.*;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1OperateBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.FilterSearchService;
import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.Result;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.*;
import static cn.luoyanze.documentmanager.dao.Tables.S1_OPERATE;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 7:55 PM
 */

@Service
public class FilterSearchServiceImpl implements FilterSearchService {

    private final DSLContext dao;

    public FilterSearchServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public FilterSearchHttpResponse execute(FilterSearchHttpRequest request) {

        switch (request.getMenuIndex()) {
            case 0:
                return wrapperUser(request);
            case 1:
                return wrapperRecord(request);
            case 2:
                return wrapperFile(request);
            case 3:
                return wrapperNotice(request);
            default:
                return null;
        }
    }

    private FilterSearchHttpResponse wrapperUser(FilterSearchHttpRequest request) {
        int totalPage = dao.fetchCount(S1_USER) / request.getPageSize();

        List<S1UserBO> users = dao.selectFrom(S1_USER)
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(S1UserBO.class);

        List<TableItemBase> items = users.stream()
                .map(it -> new UserTableItem() {{
                            setItemId(it.getPrimaryId().intValue());
                            setName(it.getAccount());
                            setBu(it.getBu());
                            setTel(it.getTel());
                        }}
                ).collect(Collectors.toList());

        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }

    private FilterSearchHttpResponse wrapperResp(int totalPage, List<TableItemBase> items, List<Pair> pairs) {
        return new FilterSearchHttpResponse() {{
            setHead(new ResponseHead(HeadStatus.SUCCESS));
            setTotalPage(totalPage);
            setItems(items);
            setPairs(pairs);
        }};
    }

    private FilterSearchHttpResponse wrapperRecord(FilterSearchHttpRequest request) {

        int totalPage = dao.fetchCount(S1_OPERATE) / request.getPageSize();

        List<S1OperateBO> records = dao.selectFrom(S1_OPERATE)
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(S1OperateBO.class);

        List<TableItemBase> items =
                records.stream()
                        .map(it -> new RecordTableItem() {{
                                    setItemId(it.getPrimaryId());
                                    setUserId(it.getPrimaryId());
                                    setOperate(it.getType().toString());
                                    setFid(it.getDocId());
                                    setOperateTime(TimeUtil.formatter(it.getTime()));
                                }}
                        ).collect(Collectors.toList());

        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }

    private FilterSearchHttpResponse wrapperFile(FilterSearchHttpRequest request) {

        int totalPage = dao.fetchCount(S1_DOC) / request.getPageSize();

        Result<Record6<String, Integer, Integer, String, LocalDateTime, String>> docs = dao.select(
                        S1_USER.ACCOUNT,
                        S1_USER.PRIMARY_ID,
                        S1_DOC.PRIMARY_ID,
                        S1_DOC.PERMISSION_BU,
                        S1_DOC.LAST_UPDATE_TIME,
                        S1_DOC.TITLE
                ).from(S1_DOC)
                .rightJoin(S1_USER)
                .on(S1_DOC.USER_ID.eq(S1_USER.PRIMARY_ID))
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetch();

        List<TableItemBase> items = docs.stream()
                .map(it -> new FileTableItem() {{
                            setOwner(it.get(0, String.class));
                            setUserId(it.get(1, Integer.class));
                            setFileId(it.get(2, Integer.class));
                            setBu(it.get(3, String.class));
                            setTime(TimeUtil.formatter(it.get(4, LocalDateTime.class)));
                            setTitle(it.get(5, String.class));
                        }}
                ).collect(Collectors.toList());

        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }


    private FilterSearchHttpResponse wrapperNotice(FilterSearchHttpRequest request) {

        int totalPage = dao.fetchCount(S1_NOTICE) / request.getPageSize();

        List<S1NoticeBO> notices = dao.selectFrom(S1_NOTICE)
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(S1NoticeBO.class);

        List<TableItemBase> items = notices.stream()
                .map(it -> new NoticeTableItem() {{
                            setBu(it.getAcceptBu());
                            setCtx(it.getContent());
                            setTo(it.getAcceptUsers());
                            setStartTime(TimeUtil.formatter(it.getStartTime()));
                            setEndTime(TimeUtil.formatter(it.getEndTime()));
                            setItemId(it.getPrimaryId());
                        }}
                ).collect(Collectors.toList());

        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }
}
