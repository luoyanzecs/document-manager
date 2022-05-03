package cn.luoyanze.common.context;

import cn.luoyanze.common.util.IdUtil;

import java.util.concurrent.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 2:21 AM
 */


public class TraceContext implements AutoCloseable {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static void set(String str) {
        threadLocal.set(str);
    }

    private static String get() {
        return threadLocal.get();
    }

    private static void clear() {
        threadLocal.remove();
    }

    @Override
    public void close() throws Exception {
        clear();
    }

    public static void setRequest(String ctx, String userId, TraceReqRecorder t) {
        String uuid = IdUtil.getUUID();
        TraceContext.set(uuid);
        // TODO: 根据生成的uuid存储 request， 利用线程池存储， TRACE表
        executor.submit(() -> t.apply(uuid, ctx, userId));
    }

    public static void setResponse(String ctx, TraceRespRecorder t) {
        String uuid = TraceContext.get();
        // TODO: 根据uuid存储response， 计算耗时
        executor.submit(() -> t.apply(uuid, ctx));

    }
}
