package cn.luoyanze.common.context;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 1:46 PM
 */

/**
 * 存储日志的接口
 * @param <T>
 */
public interface TraceReqRecorder {

    void apply(String id, String ctx, String userId);

}
