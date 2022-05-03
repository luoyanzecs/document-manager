package cn.luoyanze.documentmanager.service.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/1 8:00 PM
 */
public interface NodeType {

    String ROOT = "root";
    String ELEMENT = "element";
    String TEXT = "text";

    static String toNode(String type) {
        if (ROOT.equalsIgnoreCase(type)) {
            return ROOT;
        }
        if (TEXT.equalsIgnoreCase(type)) {
            return TEXT;
        }
        return ELEMENT;
    }
}
