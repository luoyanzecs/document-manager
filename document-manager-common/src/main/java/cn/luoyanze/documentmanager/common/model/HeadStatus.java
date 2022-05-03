package cn.luoyanze.documentmanager.common.model;

import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

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
    DELETE_ATTACH_FAIL(107,"文件删除失败"),
    MENU_INDEX_ERROR(108,"传入的菜单不合法"),
    FILE_SELECT_ERROR(109,"文件查询失败"),
    UPLOADER_FAIL(110, "文件上传失败"),
    DOC_CREATE_FAIL(111, "新建文件失败"),
    INSERT_USER_FAIL(112, "添加用户失败"),
    ;

    private final int code;
    private final String value;

    public static HeadStatus getStatus(int code) {
        for (HeadStatus status : HeadStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }
        return SUCCESS;
    }

    public static HttpStatus getHttpStatus(ResponseHead head) {
        switch (getStatus(head.getStatusCode())) {
            case SUCCESS: return HttpStatus.OK;
            default:      return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
