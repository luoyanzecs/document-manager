package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequsetHead;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:32 AM
 */


@Getter
public class AddNoticeHttpRequest {

    private RequsetHead head;

    private String text;

    private boolean isGlobal;

    private int type;

    private LocalDateTime startTime;

    private LocalDateTime expiredTime;
}
