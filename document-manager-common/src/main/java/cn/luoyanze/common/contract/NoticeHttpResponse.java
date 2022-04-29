package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:46 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class NoticeHttpResponse extends BaseHttpResponse {

    private List<Notice> notices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Notice {
        @JsonProperty("id")
        private Integer id;

        /**
         * 消息类型 1：成功； 2：失败； 其他：普通信息
         */
        @JsonProperty("type")
        private int type;

        @JsonProperty("message")
        private String message;
    }

}
