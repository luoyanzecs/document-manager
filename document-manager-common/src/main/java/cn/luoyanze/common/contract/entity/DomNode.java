package cn.luoyanze.common.contract.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/1 12:41 AM
 */


@Getter
@NoArgsConstructor
public class DomNode {

    @JsonProperty("style")
    private List<String> styles;

    @JsonProperty("class")
    private List<String> classes;

    @JsonProperty("z-id")
    private List<String> id;

    @JsonProperty("z-index")
    private String index;

    @JsonProperty("z-hash")
    private String hash;

    @JsonProperty("z-children")
    private String children;

    @JsonProperty("z-parent")
    private String parent;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("node")
    private String type;

    @JsonProperty("text")
    private String text;
}