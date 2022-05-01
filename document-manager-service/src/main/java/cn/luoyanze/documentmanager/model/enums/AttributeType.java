package cn.luoyanze.documentmanager.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttributeType {

    ID("data-id"),
    PARENT("data-parent"),
    INDEX("data-index"),
    HASH("data-hash"),
    CHILDREN("data-children"),
    STYLE("style"),
    CLASS("class"),
    CUSTOM_TAG("zzz"),
    ;

    private final String value;
}
