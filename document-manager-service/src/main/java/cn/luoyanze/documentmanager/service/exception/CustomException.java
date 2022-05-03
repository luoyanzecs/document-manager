package cn.luoyanze.documentmanager.service.exception;

import cn.luoyanze.documentmanager.common.model.HeadStatus;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/25 12:22 AM
 */


public class CustomException extends GlobalException{

    private final HeadStatus status;

    public CustomException(String message, HeadStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    HeadStatus getStatus() {
        return status;
    }
}
