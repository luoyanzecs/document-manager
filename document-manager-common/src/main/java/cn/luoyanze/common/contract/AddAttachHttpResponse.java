package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:22 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAttachHttpResponse {

    private ResponseHead head;

    private Attach attach;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Attach {

        private String name;

        @JsonProperty("link")
        private Integer id;
    }
}
