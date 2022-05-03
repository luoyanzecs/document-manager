package cn.luoyanze.documentmanager.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 10:27 PM
 */

@Getter
@AllArgsConstructor
public enum TokenResult {
    // 成功
    SUCCESS("验证成功"),
    // 超时
    EXPIRE("token超时"),
    // 非法
    ILLEGAL("token非法"),
    // 失败
    FAIL("校验失败");

    private final String value;
    
    public static boolean checkValid(TokenResult o) {
        return o == SUCCESS;
    }

}
