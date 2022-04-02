package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:44 PM
 */

public class AdminNoticesHttpRequest {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("page")
    private int page;

    @JsonProperty("pageSize")
    private int size;

    public RequsetHead getHead() {
        return head;
    }

    public void setHead(RequsetHead head) {
        this.head = head;
    }

    public int getPage() {
        return page;
    }
}
