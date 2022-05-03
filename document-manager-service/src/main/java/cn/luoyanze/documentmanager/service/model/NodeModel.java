package cn.luoyanze.documentmanager.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/1 7:46 PM
 */

@Data
public class NodeModel {

    @JsonProperty("attr")
    private Map<String, String> attr;

    @JsonProperty("node")
    private String type;

    @JsonProperty("tag")
    private String tag;

    @JsonProperty("text")
    private String text;

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String index;

    @JsonIgnore
    private String parentId;

    @JsonProperty("child")
    private List<NodeModel> children;
}
