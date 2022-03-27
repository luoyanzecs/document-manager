package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.model.Head;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:42 PM
 *
 */

public class AdminUsersHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private Head head;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
