package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:22 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAttachHttpResponse extends BaseHttpResponse {

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
