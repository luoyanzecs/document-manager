package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:46 PM
 */

@Data
public class NoticeHttpRequset {

    @JsonProperty("head")
    private RequsetHead head;


    public RequsetHead getHead() {
        return head;
    }

    public void setHead(RequsetHead head) {
        this.head = head;
    }
}
