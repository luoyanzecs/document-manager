package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.Head;
import cn.luoyanze.documentmanager.contract.entity.Notice;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:46 PM
 */

public class NoticeHttpResponse {

    /**
     * 头信息
     */
    private Head head;

    private List<Notice> notices;

    public NoticeHttpResponse(Head head, List<Notice> notices) {
        this.head = head;
        this.notices = notices;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }
}
