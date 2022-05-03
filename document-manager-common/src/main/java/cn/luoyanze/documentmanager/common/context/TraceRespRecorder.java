package cn.luoyanze.documentmanager.common.context;

import java.time.LocalDateTime;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 1:54 PM
 */

public interface TraceRespRecorder {
    void apply(String id, String ctx, LocalDateTime time, Long requestTimeStamp);
}
