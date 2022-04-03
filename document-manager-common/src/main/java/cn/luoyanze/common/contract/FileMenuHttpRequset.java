package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.RequsetHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

public class FileMenuHttpRequset {

    @JsonProperty("head")
    private RequsetHead head;

    @JsonProperty("bu")
    private String bu;

    public RequsetHead getHead() {
        return head;
    }

    public void setHead(RequsetHead head) {
        this.head = head;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }
}
