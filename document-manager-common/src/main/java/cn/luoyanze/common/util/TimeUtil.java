package cn.luoyanze.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/5 1:47 PM
 */


public class TimeUtil {

    public static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    public static long getTimeStamp() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static String formatter(LocalDateTime time) {
        if (time == null) {
            return "尚未登录";
        }
        return time.format(DateTimeFormatter.ofPattern("yyy年MM月d日 HH:mm", Locale.CHINA));
    }
}
