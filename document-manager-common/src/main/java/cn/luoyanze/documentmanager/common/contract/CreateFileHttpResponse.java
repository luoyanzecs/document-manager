package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:52 PM
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateFileHttpResponse extends BaseHttpResponse {

    private Integer fileId;
}
