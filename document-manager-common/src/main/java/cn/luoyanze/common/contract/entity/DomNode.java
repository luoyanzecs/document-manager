package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/1 12:41 AM
 */


@Getter
@NoArgsConstructor
public class DomNode {

    @JsonProperty("style")
    private String styles;

    @JsonProperty("class")
    private String classes;

    @JsonProperty("data-id")
    private String id;

    @JsonProperty("data-index")
    private String index;

    @JsonProperty("data-hash")
    private String hash;

    @JsonProperty("data-children")
    private String children;

    @JsonProperty("data-parent")
    private String parent;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("node")
    private String type;

    @JsonProperty("text")
    private String text;

    @JsonProperty("attr")
    private Map<String, String> attr;
}