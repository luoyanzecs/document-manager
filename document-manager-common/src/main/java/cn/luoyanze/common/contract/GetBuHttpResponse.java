package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 3:18 PM
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class GetBuHttpResponse extends BaseHttpResponse {

    private List<Bu> buList;

    @Data
    @AllArgsConstructor
    public static class Bu {
        private Integer buId;
        private String name;
    }
}
