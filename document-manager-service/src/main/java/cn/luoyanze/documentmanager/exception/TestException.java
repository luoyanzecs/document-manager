package cn.luoyanze.documentmanager.exception;

import cn.luoyanze.common.model.HeadStatus;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 10:37 PM
 */

public class TestException extends GlobalException {

    public TestException(String message) {
        super(message);
    }

    @Override
    public HeadStatus getStatus() {
        return HeadStatus.FILE_NOT_EXISIT;
    }
}
