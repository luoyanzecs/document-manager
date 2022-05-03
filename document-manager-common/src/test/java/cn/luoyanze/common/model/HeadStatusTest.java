package cn.luoyanze.common.model;

import cn.luoyanze.documentmanager.common.model.HeadStatus;
import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 10:58 PM
 */


public class HeadStatusTest {
    @Test
    public void test() {
        System.out.println(HeadStatus.SUCCESS.getCode());
        System.out.println(HeadStatus.SUCCESS.getValue());
    }
}
