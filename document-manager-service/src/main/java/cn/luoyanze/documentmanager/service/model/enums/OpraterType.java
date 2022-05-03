package cn.luoyanze.documentmanager.service.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OpraterType {

    UPDATE_FILE(1, "更新内容"),
    CREATE_FILE(2, "创建文件"),
    DELETE_ATTACH(3, "删除附件"),
    BROWSER_FILE(4, "浏览文件"),
    ;

    private final int id;
    private final String value;

    public static String getValue(int i) {

        for (OpraterType type : OpraterType.values()) {
            if (type.id == i) {
                return type.value;
            }
        }
        return "未知";
    }
}
