package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.ResponseHead;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 11:52 PM
 */

@Data
public class CreateFileHttpResponse {

    private ResponseHead head;

    private String fileId;
}
