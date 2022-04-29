package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FileCommentHttpResponse extends BaseHttpResponse {

    /**
     * 评论列表
     */
    @JsonProperty("comments")
    private List<Comment> comments;

    @Data
    public static class Comment {
        @JsonProperty("commentId")
        private Integer id;

        @JsonProperty("name")
        private String username;

        @JsonProperty("id")
        private Integer userId;

        @JsonProperty("time")
        private String time;

        @JsonProperty("avatar")
        private String avatar;

        @JsonProperty("ctx")
        private String ctx;

        @JsonProperty("reply")
        private List<Comment> reply;
    }

}
