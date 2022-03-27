package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.model.Head;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:46 PM
 */


public class NoticeHttpResponse {

    /**
     * 头信息
     */
    private Head head;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
