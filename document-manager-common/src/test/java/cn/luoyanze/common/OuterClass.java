package cn.luoyanze.common;

import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:56 AM
 */

@Data
public class OuterClass {

    private int out;

    @Data
    static class InnerClass {
        private int in;
    }
}
