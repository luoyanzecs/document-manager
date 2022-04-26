package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:47 PM
 */

@Data
public class UserFileHttpResponse {

    /**
     * 头信息
     */
    @JsonProperty("head")
    private ResponseHead head;

    @JsonProperty("fileInfo")
    private File file;

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
