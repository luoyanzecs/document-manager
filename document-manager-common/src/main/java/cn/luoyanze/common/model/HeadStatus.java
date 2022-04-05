package cn.luoyanze.common.model;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 9:00 PM
 */


public enum HeadStatus {

    SUCCESS(200, "OK"),
    FORBBIDEN(101, "用户权限不足"),
    USER_NOT_EXISIT(102, "用户不存在"),
    FILE_NOT_EXISIT(103, "文件不存在")
    ;

    private int code;
    private String value;

    HeadStatus(int code, String value) {
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
