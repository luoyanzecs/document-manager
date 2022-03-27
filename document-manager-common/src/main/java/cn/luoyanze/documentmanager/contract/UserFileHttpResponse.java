package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.File;
import cn.luoyanze.documentmanager.contract.entity.Head;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */


public class UserFileHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private Head head;

    @JsonProperty("fileInfo")
    private File file;

    public UserFileHttpResponse(Head head, File file) {
        this.head = head;
        this.file = file;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
