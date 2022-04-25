package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:45 PM
 */

@Data
public class LoginHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    /**
     * 用户信息
     */
    @JsonProperty("userInfo")
    private User user;

    @JsonProperty("token")
    private String token;

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public static class User {
        /**
         * 用户名
         */
        @JsonProperty("name")
        private String name;

        /**
         * 头像
         */
        @JsonProperty("avatar")
        private String avatar;

        /**
         * 用户id
         */
        @JsonProperty("id")
        private Integer id;

        /**
         * 用户所在部门
         */
        @JsonProperty("bu")
        private Integer bu;

        /**
         * 用户等级
         */
        @JsonProperty("rank")
        private int rank;
    }

}
