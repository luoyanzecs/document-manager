package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.entity.RecordInAdmin;
import cn.luoyanze.common.contract.entity.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:43 PM
 */


public class AdminRecordsHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    @JsonProperty("fields")
    private List<String> fields;

    @JsonProperty("keys")
    private List<String> keys;

    @JsonProperty("cols")
    private List<Integer> cols;

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("totalPage")
    private Integer totalPage;

    @JsonProperty("items")
    private List<RecordInAdmin> records;

    public AdminRecordsHttpResponse(ResponseHead head, List<String> fields, List<String> keys, List<Integer> cols, Integer currentPage, Integer totalPage, List<RecordInAdmin> records) {
        this.head = head;
        this.fields = fields;
        this.keys = keys;
        this.cols = cols;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.records = records;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public List<Integer> getCols() {
        return cols;
    }

    public void setCols(List<Integer> cols) {
        this.cols = cols;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<RecordInAdmin> getRecords() {
        return records;
    }

    public void setRecords(List<RecordInAdmin> records) {
        this.records = records;
    }
}
