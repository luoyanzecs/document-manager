package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:42 PM
 */


public class AdminUsersHttpRequest {

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

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
