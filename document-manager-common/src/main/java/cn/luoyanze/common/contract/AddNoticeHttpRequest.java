package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:32 AM
 */


@Getter
public class AddNoticeHttpRequest {

    private RequestHead head;

    private String text;

    private boolean isGlobal;

    private int type;

    private LocalDateTime startTime;

    private LocalDateTime expiredTime;

    private List<String> bu;

    private List<Integer> users;
}
