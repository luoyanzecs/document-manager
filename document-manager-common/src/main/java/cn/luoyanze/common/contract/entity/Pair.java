package cn.luoyanze.common.contract.entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 12:03 AM
 */

@Data
public class Pair {
    private String name;
    private String key;

    Pair(String name, String key) {
        this.name = name;
        this.key = key;
    }


    public static List<Pair> getPairs(int index) {
        switch (index) {
            case 0:
                return List.of(
                        new Pair("UUID", "id"),
                        new Pair("用户名", "name"),
                        new Pair("用户ID", "userId"),
                        new Pair("部门", "bu"),
                        new Pair("联系方式", "tel")
                );
            case 1:
                return List.of(
                        new Pair("UUID", "itemId"),
                        new Pair("用户ID", "userId"),
                        new Pair("文件ID", "fid"),
                        new Pair("操作时间", "operateTime"),
                        new Pair("操作类型", "operate"),
                        new Pair("部门", "bu")
                );
            case 2:
                return List.of(
                        new Pair("UUID", "id"),
                        new Pair("所属用户", "owner"),
                        new Pair("用户ID", "userId"),
                        new Pair("标题", "title"),
                        new Pair("部门", "bu"),
                        new Pair("创建时间", "createTime")
                );
            case 3:
                return List.of(
                        new Pair("UUID", "id"),
                        new Pair("接收用户", "to"),
                        new Pair("开始时间", "startTime"),
                        new Pair("结束时间", "endTime"),
                        new Pair("通知内容", "ctx"),
                        new Pair("接收部门", "bu")
                );
            default:
                return Collections.emptyList();
        }
    }
}
