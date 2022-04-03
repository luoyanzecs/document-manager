package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.Notice;
import cn.luoyanze.common.contract.entity.ResponseHead;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:46 PM
 */

public class NoticeHttpResponse {

    /**
     * 头信息
     */
    private ResponseHead head;

    private List<Notice> notices;

    public NoticeHttpResponse(ResponseHead head, List<Notice> notices) {
        this.head = head;
        this.notices = notices;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<Notice> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice> notices) {
        this.notices = notices;
    }
}
