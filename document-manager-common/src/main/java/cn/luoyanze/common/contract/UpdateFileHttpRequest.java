package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.RequestHead;
import lombok.Getter;
import org.jooq.types.UInteger;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/9 10:09 PM
 */

@Getter
public class UpdateFileHttpRequest {

    private RequestHead head;

    /**
     * json 格式内容
     */
    private String jsonValue;

    /**
     * 文件id
     */
    private Integer fileId;


    /**
     * 更改文件用户的id
     */
    private Integer userid;
}
