package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */

public class FileCommentHttpRequset {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("fileId")
    private String id;

    public RequsetHead getHead() {
        return head;
    }

    public void setHead(RequsetHead head) {
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
