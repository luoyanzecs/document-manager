package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserFileHttpResponse extends BaseHttpResponse {


    @JsonProperty("fileInfo")
    private File file;

    @JsonProperty("rootAttr")
    private Map<String, String> rootAttr;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class File {
        @JsonProperty("editor")
        private String editor;

        @JsonProperty("lastEditTime")
        private String lastTime;

        @JsonProperty("fileContent")
        private String ctx;

        private List<Attach> attaches;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Attach {
        private String name;

        @JsonProperty("link")
        private Integer primaryId;
    }
}
