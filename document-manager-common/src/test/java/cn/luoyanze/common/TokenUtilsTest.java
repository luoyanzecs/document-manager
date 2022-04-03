package cn.luoyanze.common;

import cn.luoyanze.common.eunm.TokenResult;
import cn.luoyanze.common.util.TokenUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 10:22 PM
 */

public class TokenUtilsTest {

    @Test
    public void test() {
        String token = TokenUtils.buildJWT("luoyanze");
        System.out.println(token);
        TokenResult res = TokenUtils.vaildToken(token, "luoyanze");

        System.out.println(res.getValue());
    }
}
