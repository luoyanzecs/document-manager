package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 1:48 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class FileMenuHttpResponse extends BaseHttpResponse {

    /**
     * 目录列表
     */
    @JsonProperty("items")
    private List<Menu> menus;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Menu {
        /**
         * 条目id
         */
        @JsonProperty("id")
        private Integer id;

        /**
         * 标题
         */
        @JsonProperty("title")
        private String title;

        private boolean isDir;

        /**
         * 子文件
         */
        @JsonProperty("children")
        private List<Menu> subs;
    }
}
