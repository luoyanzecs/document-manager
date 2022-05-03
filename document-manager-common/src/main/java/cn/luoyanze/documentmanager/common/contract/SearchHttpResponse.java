package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:49 AM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchHttpResponse extends BaseHttpResponse {

    private List<Result> searchResults;

    @Data
    @Accessors(chain = true)
    public static class Result {
        private Integer id;
        private String title;
        private String ctx;
        private String author;
    }
}
