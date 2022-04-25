package cn.luoyanze.common.contract.common;

import lombok.Data;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 8:38 PM
 */
@Data
public class RequestHead {

    private String timestamp;

    private Integer userId;

    private String username;

    private String role;

    private String token;

    private Integer bu;

    private Integer rank;
}
