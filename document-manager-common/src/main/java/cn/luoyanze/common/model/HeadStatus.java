package cn.luoyanze.common.model;

import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 9:00 PM
 */

public enum HeadStatus {

    SUCCESS(200, "OK"),
    FORBBIDEN(101, "用户权限不足"),
    USER_NOT_EXISIT(102, "用户不存在"),
    FILE_NOT_EXISIT(103, "文件不存在"),
    INSERT_COMMENT_FAIL(104, "评论添加失败"),
    INSERT_NOTICE_FAIL(105, "通知添加失败"),

    UPDATE_FILE_FAIL(106,"文件更新失败"),
    DELETE_ATTACH_FAIL(107,"文件删除失败"),
    UPLOADER_FAIL(110, "文件上传失败");


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
