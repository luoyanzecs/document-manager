package cn.luoyanze.documentmanager.contract;

import cn.luoyanze.documentmanager.contract.entity.File;
import cn.luoyanze.documentmanager.contract.entity.ResponseHead;
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
    private ResponseHead head;

    @JsonProperty("fileInfo")
    private File file;

    public UserFileHttpResponse(ResponseHead head, File file) {
        this.head = head;
        this.file = file;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead responseHead) {
        this.head = responseHead;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
