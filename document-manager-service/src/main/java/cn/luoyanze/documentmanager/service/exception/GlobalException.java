package cn.luoyanze.documentmanager.service.exception;

import cn.luoyanze.documentmanager.common.model.HeadStatus;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 11:22 PM
 */

public abstract class GlobalException extends Exception{

    public GlobalException(String message) {
        super(message);
    }

    abstract HeadStatus getStatus();
}
