package cn.luoyanze.documentmanager.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttributeType {

    ID("z-id"),
    PARENT("z-parent"),
    INDEX("z-index"),
    HASH("z-hash"),
    CHILDREN("z-children"),
    STYLE("style"),
    CLASS("class"),
    CUSTOM_TAG("zzz"),
    ;

    private final String value;
}
