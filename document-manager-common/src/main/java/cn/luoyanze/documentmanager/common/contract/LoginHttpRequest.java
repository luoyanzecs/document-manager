package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:45 PM
 */

@Getter
public class LoginHttpRequest extends BaseHttpRequest {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    private String role;
}
