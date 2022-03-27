package cn.luoyanze.documentmanager.contract.entity;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:28 AM
 */
public class Head {
    /**
     * 状态 成功：success， 失败：error
     */
    private String status;

    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 消息
     */
    private String massage;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
