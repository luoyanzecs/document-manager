package cn.luoyanze.common;

import cn.luoyanze.common.model.TokenResult;
import cn.luoyanze.common.util.TokenUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 10:22 PM
 */

public class TokenUtilTest {

    @Test
    public void test() {
        String token = TokenUtil.buildJWT("luoyanze");
        System.out.println(token);
        TokenResult res = TokenUtil.vaildToken(token, "luoyanze");

        System.out.println(res.getValue());
    }
}
