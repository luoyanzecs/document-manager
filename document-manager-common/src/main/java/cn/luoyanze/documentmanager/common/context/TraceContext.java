package cn.luoyanze.documentmanager.common.context;

import cn.luoyanze.documentmanager.common.util.IdUtil;
import cn.luoyanze.documentmanager.common.util.TimeUtil;

import java.util.concurrent.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 2:21 AM
 */


public class TraceContext implements AutoCloseable {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private static final ThreadLocal<String> iDThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Long> timeThreadLocal = new ThreadLocal<>();

    private static void setId(String str) {
        iDThreadLocal.set(str);
    }

    private static String getId() {
        return iDThreadLocal.get();
    }

    private static void setTimeStamp(Long time) {
        timeThreadLocal.set(time);
    }

    private static Long getTimeStamp() {
        return timeThreadLocal.get();
    }

    private static void clear() {
        iDThreadLocal.remove();
        timeThreadLocal.remove();
    }

    @Override
    public void close() throws Exception {
        clear();
    }

    public static void setRequest(String ctx, String userId, TraceReqRecorder t) {
        String uuid = IdUtil.getUUID();
        setId(uuid);
        setTimeStamp(TimeUtil.getTimeStamp());
        // TODO: 根据生成的uuid存储 request， 利用线程池存储， TRACE表
        executor.submit(() -> t.apply(uuid, ctx, userId, TimeUtil.now()));
    }

    public static void setResponse(String ctx, TraceRespRecorder t) {
        // TODO: 根据uuid存储response， 计算耗时
        executor.submit(() -> t.apply(getId(), ctx, TimeUtil.now(), getTimeStamp()));

    }
}
