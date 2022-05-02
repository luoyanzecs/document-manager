/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S1TraceBO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String        uuid;
    private Integer       userId;
    private String        url;
    private String        storeRequest;
    private String        storeResponse;
    private LocalDateTime requestTime;
    private LocalDateTime responseTime;
    private Integer       internal;

    public S1TraceBO() {}

    public S1TraceBO(S1TraceBO value) {
        this.uuid = value.uuid;
        this.userId = value.userId;
        this.url = value.url;
        this.storeRequest = value.storeRequest;
        this.storeResponse = value.storeResponse;
        this.requestTime = value.requestTime;
        this.responseTime = value.responseTime;
        this.internal = value.internal;
    }

    public S1TraceBO(
        String        uuid,
        Integer       userId,
        String        url,
        String        storeRequest,
        String        storeResponse,
        LocalDateTime requestTime,
        LocalDateTime responseTime,
        Integer       internal
    ) {
        this.uuid = uuid;
        this.userId = userId;
        this.url = url;
        this.storeRequest = storeRequest;
        this.storeResponse = storeResponse;
        this.requestTime = requestTime;
        this.responseTime = responseTime;
        this.internal = internal;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.uuid</code>. traceid
     */
    public String getUuid() {
        return this.uuid;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.uuid</code>. traceid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.user_id</code>. 用户id
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.user_id</code>. 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.url</code>. 请求路径
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.url</code>. 请求路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.store_request</code>. 请求body
     */
    public String getStoreRequest() {
        return this.storeRequest;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.store_request</code>. 请求body
     */
    public void setStoreRequest(String storeRequest) {
        this.storeRequest = storeRequest;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.store_response</code>. 响应body
     */
    public String getStoreResponse() {
        return this.storeResponse;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.store_response</code>. 响应body
     */
    public void setStoreResponse(String storeResponse) {
        this.storeResponse = storeResponse;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.request_time</code>. 请求时间
     */
    public LocalDateTime getRequestTime() {
        return this.requestTime;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.request_time</code>. 请求时间
     */
    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.response_time</code>. 响应时间
     */
    public LocalDateTime getResponseTime() {
        return this.responseTime;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.response_time</code>. 响应时间
     */
    public void setResponseTime(LocalDateTime responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Getter for <code>document_manager.S1_TRACE.internal</code>. 处理总时间
     */
    public Integer getInternal() {
        return this.internal;
    }

    /**
     * Setter for <code>document_manager.S1_TRACE.internal</code>. 处理总时间
     */
    public void setInternal(Integer internal) {
        this.internal = internal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("S1TraceBO (");

        sb.append(uuid);
        sb.append(", ").append(userId);
        sb.append(", ").append(url);
        sb.append(", ").append(storeRequest);
        sb.append(", ").append(storeResponse);
        sb.append(", ").append(requestTime);
        sb.append(", ").append(responseTime);
        sb.append(", ").append(internal);

        sb.append(")");
        return sb.toString();
    }
}
