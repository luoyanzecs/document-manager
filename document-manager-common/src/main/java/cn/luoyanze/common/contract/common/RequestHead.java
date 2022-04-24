package cn.luoyanze.common.contract.common;

import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 8:38 PM
 */

@Getter
public class RequestHead {

    private String timestamp;

    private Integer userId;

    private String username;

    private String role;

    private String token;
}
