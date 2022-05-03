package cn.luoyanze.documentmanager.service.service.impl;

import cn.luoyanze.documentmanager.common.contract.FilterSearchHttpRequest;
import cn.luoyanze.documentmanager.common.contract.FilterSearchHttpResponse;
import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.common.contract.entity.*;
import cn.luoyanze.documentmanager.common.model.HeadStatus;
import cn.luoyanze.documentmanager.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1BuBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1NoticeBO;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1UserBO;
import cn.luoyanze.documentmanager.service.model.enums.OpraterType;
import cn.luoyanze.documentmanager.service.service.FilterSearchService;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
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
        int totalPage = dao.fetchCount(S1_USER) / request.getPageSize() + 1;
        List<S1BuBO> bus = dao.selectFrom(S1_BU).fetchInto(S1BuBO.class);


        List<TableItemBase> items = dao.selectFrom(S1_USER)
                .where(request.getUserIds().stream().map(S1_USER.PRIMARY_ID::eq).reduce(DSL.noCondition(), Condition::or))
                .and(request.getBu().stream().map(S1_USER.BU_ID::eq).reduce(DSL.noCondition(), Condition::or))
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(S1UserBO.class)
                .stream().map(it -> new UserTableItem() {{
                            setId(it.getPrimaryId());
                            setName(it.getAccount());
                            setBu(bus.stream()
                                    .filter(bu -> Objects.equals(bu.getPrimaryId(), it.getBuId()))
                                    .findFirst()
                                    .map(S1BuBO::getName)
                                    .orElse("暂无")
                            );
                            setTel(it.getTel());
                            setRegisterTime(TimeUtil.formatter(it.getRegisterTime()));
                            setRole(it.getRole());
                            setIsDel(it.getIsdel() == 0 ? "否" : "是");
                            setStatus(it.getStatus() == 1 ? "在职" : "离职");
                            setLastLoginTime(TimeUtil.formatter(it.getLastLoginTime()));
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

        int totalPage = dao.fetchCount(S1_OPERATE) / request.getPageSize() + 1;

        List<TableItemBase> items = dao.select(S1_OPERATE.PRIMARY_ID,
                        S1_OPERATE.DOC_ID,
                        S1_OPERATE.USER_ID,
                        S1_OPERATE.TYPE,
                        S1_OPERATE.TIME,
                        S1_OPERATE.CONTENT,
                        S1_USER.ACCOUNT
                )
                .from(S1_OPERATE)
                .leftJoin(S1_USER)
                .on(S1_OPERATE.USER_ID.eq(S1_USER.PRIMARY_ID))
                .where(request.getUserIds().stream().map(S1_USER.PRIMARY_ID::eq).reduce(DSL.noCondition(), Condition::or))
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetch()
                .stream().map(it ->
                        new RecordTableItem() {{
                            setItemId(it.get(S1_OPERATE.PRIMARY_ID));
                            setUserId(it.get(S1_OPERATE.USER_ID));
                            setOperate(OpraterType.getValue(it.get(S1_OPERATE.TYPE)));
                            setFid(it.get(S1_OPERATE.DOC_ID));
                            setOperateTime(TimeUtil.formatter(it.get(S1_OPERATE.TIME)));
                            setContent(it.get(S1_OPERATE.CONTENT));
                            setOperator(it.get(S1_USER.ACCOUNT));
                        }})
                .collect(Collectors.toList());


        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }

    private FilterSearchHttpResponse wrapperFile(FilterSearchHttpRequest request) {

        int totalPage = dao.fetchCount(S1_DOC) / request.getPageSize() + 1;
        List<S1BuBO> BUS = dao.selectFrom(S1_BU).fetchInto(S1BuBO.class);

        List<TableItemBase> items = dao.select(S1_USER.ACCOUNT, S1_DOC.USER_ID, S1_DOC.PRIMARY_ID, S1_DOC.PERMISSION_BU, S1_DOC.LAST_UPDATE_TIME, S1_DOC.TITLE)
                .from(S1_DOC)
                .leftJoin(S1_USER)
                .on(S1_DOC.USER_ID.eq(S1_USER.PRIMARY_ID))
                // 判断接收部门是否全部包含传入参数
                .where(request.getBu().stream().map(String::valueOf)
                        .map(S1_DOC.PERMISSION_BU::contains)
                        .reduce(DSL.trueCondition(), Condition::and)
                        .or(S1_DOC.PERMISSION_BU.eq(""))
                )
                // 判断是否在用户id集合内
                .and(request.getUserIds().stream().map(S1_DOC.USER_ID::eq).reduce(DSL.noCondition(), Condition::or))
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetch()
                .stream().map(it -> new FileTableItem() {{
                    setOwner(it.get(S1_USER.ACCOUNT));
                    setUserId(it.get(S1_DOC.USER_ID));
                    setFileId(it.get(S1_DOC.PRIMARY_ID));
                    setBu(convertToBuName(it.get(S1_DOC.PERMISSION_BU), BUS));
                    setTime(TimeUtil.formatter(it.get(S1_DOC.LAST_UPDATE_TIME)));
                    setTitle(it.get(S1_DOC.TITLE));
                }}).collect(Collectors.toList());


        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }

    private String convertToBuName(String str, List<S1BuBO> BUS) {
        String res =  Optional.of(str)
                .filter(it -> !StringUtils.isEmpty(it))
                .map(it -> Arrays.stream(it.split(","))
                        .filter(StringUtils::isEmpty)
                        .map(id -> BUS.stream()
                                .filter(bu -> bu.getPrimaryId().toString().equals(id))
                                .findFirst()
                                .map(S1BuBO::getName).orElse(null))
                        .filter(StringUtils::isEmpty)
                        .collect(Collectors.joining(",")))
                .orElse("所有");
        return res.isEmpty() || res.isBlank() ? "所有" : res;
    }

    private FilterSearchHttpResponse wrapperNotice(FilterSearchHttpRequest request) {

        int totalPage = dao.fetchCount(S1_NOTICE) / request.getPageSize() + 1;
        List<S1BuBO> BUS = dao.selectFrom(S1_BU).fetchInto(S1BuBO.class);

        List<S1NoticeBO> notices = dao.selectFrom(S1_NOTICE)
                .offset((request.getPage() - 1) * request.getPageSize())
                .limit(request.getPageSize())
                .fetchInto(S1NoticeBO.class);

        List<TableItemBase> items = notices.stream()
                .map(it -> new NoticeTableItem() {{
                            setBu(convertToBuName(it.getAcceptBu(), BUS));
                            setCtx(it.getContent());
                            setTo(it.getAcceptUsers().isEmpty() ? "所有用户" : it.getAcceptUsers());
                            setStartTime(TimeUtil.formatter(it.getStartTime()));
                            setEndTime(TimeUtil.formatter(it.getEndTime()));
                            setItemId(it.getPrimaryId());
                            setUserId(it.getUserId());
                        }}
                ).collect(Collectors.toList());

        return wrapperResp(totalPage, items, Pair.getPairs(request.getMenuIndex()));
    }
}
