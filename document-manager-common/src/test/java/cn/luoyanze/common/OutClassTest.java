package cn.luoyanze.common;

import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:57 AM
 */


public class OutClassTest {

    @Test
    public void test() {


        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.setIn(12);

        OuterClass.InnerClass innerClass1 = new OuterClass.InnerClass();
        innerClass1.setIn(20);

        System.out.println(innerClass.getIn());
        System.out.println(innerClass1.getIn());
    }
}
