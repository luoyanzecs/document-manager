package cn.luoyanze.common.util;

import java.util.UUID;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 11:17 PM
 */


public class IdUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
