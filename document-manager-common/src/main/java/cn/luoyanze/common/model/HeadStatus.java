package cn.luoyanze.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 9:00 PM
 */
@Getter
@AllArgsConstructor
public enum HeadStatus {

    SUCCESS(200, "OK"),
    FORBBIDEN(101, "用户权限不足"),
    USER_NOT_EXISIT(102, "用户不存在"),
    FILE_NOT_EXISIT(103, "文件不存在"),
    INSERT_COMMENT_FAIL(104, "评论添加失败"),
    INSERT_NOTICE_FAIL(105, "通知添加失败"),
    UPDATE_FILE_FAIL(106,"文件更新失败"),
    UPLOADER_FAIL(110, "文件上传失败"),
    DOC_CREATE_FAIL(111, "新建文件失败")
    ;

    private final int code;
    private final String value;
}
