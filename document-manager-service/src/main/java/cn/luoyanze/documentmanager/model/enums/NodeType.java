package cn.luoyanze.documentmanager.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/1 8:00 PM
 */

@Getter
@AllArgsConstructor
public enum NodeType {

    ROOT("root"),
    ELEMENT("element"),
    TEXT("text")
    ;

    private final String type;

    public static NodeType toNode(String str) {

        if ("text".equalsIgnoreCase(str)) return TEXT;
        if ("element".equalsIgnoreCase(str)) return ELEMENT;
        if ("root".equalsIgnoreCase(str)) return ROOT;

        return ELEMENT;
    }
}
