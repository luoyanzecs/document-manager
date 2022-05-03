package cn.luoyanze.documentmanager.common.context;

import java.time.LocalDateTime;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 1:46 PM
 */

public interface TraceReqRecorder {

    void apply(String id, String ctx, String userId, LocalDateTime time);

}
