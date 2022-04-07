package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.FileMenuHttpRequset;
import cn.luoyanze.common.contract.FileMenuHttpResponse;
import cn.luoyanze.common.contract.entity.Menu;
import cn.luoyanze.common.contract.entity.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1DirBO;
import cn.luoyanze.documentmanager.model.DocVO;
import cn.luoyanze.documentmanager.service.UserMenuApiService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.luoyanze.documentmanager.dao.Tables.S1_DIR;
import static cn.luoyanze.documentmanager.dao.Tables.S1_DOC;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 2:18 PM
 */
@Service
public class UserMenuApiServiceImpl implements UserMenuApiService {

    private final DSLContext dao;
    private static volatile Map<String, AtomicInteger> versionMap = new ConcurrentHashMap<>();

    public UserMenuApiServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public FileMenuHttpResponse excute(FileMenuHttpRequset requset) {

        List<S1DirBO> dirs = dao.selectFrom(S1_DIR).where(S1_DIR.BU.eq(requset.getBu())).fetchInto(S1DirBO.class);

        List<DocVO> docVOS = dao.select().from(S1_DOC).fetchInto(DocVO.class);

        FileMenuHttpResponse resp = new FileMenuHttpResponse();
        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setMenus(generate(dirs, docVOS));

        return resp;
    }

    private List<Menu> generate(List<S1DirBO> dirs, List<DocVO> docVOS) {

        List<Menu> root = dirs.stream()
                .filter(it -> it.getParentId().intValue() == 0)
                .map(it -> new Menu(it.getPrimaryId().toString(), it.getTitle(), true, new ArrayList<>()))
                .collect(Collectors.toList());
        List<S1DirBO> subDirNodes;
        List<Menu> parents = root;
        do {
            Set<String> parentsId = parents.stream().map(Menu::getId).collect(Collectors.toSet());
            // 获取所有的subs节点
            subDirNodes = dirs.stream()
                    .filter(it -> parentsId.contains(it.getParentId().toString()))
                    .collect(Collectors.toList());

            List<Menu> nextLoopParents = new ArrayList<>();
            for (Menu parent : parents) {
                // 获取sub节点, 目录节点
                List<Menu> subNodeInEachParent =
                        subDirNodes.stream().filter(o -> parent.getId().equals(o.getParentId().toString()))
                                .map(it -> new Menu(it.getPrimaryId().toString(), it.getTitle(), true, new ArrayList<>()))
                                .collect(Collectors.toList());

                nextLoopParents.addAll(subNodeInEachParent);

                subNodeInEachParent.addAll(
                        docVOS.stream().filter(it -> it.getParentId().equals(parent.getId()))
                                .map(it -> new Menu(it.getUuid(), it.getTitle(), false, Collections.emptyList()))
                                .collect(Collectors.toList())
                );
                parent.setSubs(subNodeInEachParent);
            }

            parents = nextLoopParents;
        } while (!subDirNodes.isEmpty());

        return root;
    }
}
