package cn.luoyanze.common.eunm;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 10:27 PM
 */

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

    TokenResult(String value) {
        this.value = value;
    }

    public static boolean checkValid(TokenResult o) {
        return o == SUCCESS;
    }

    public String getValue() {
        return value;
    }
}
