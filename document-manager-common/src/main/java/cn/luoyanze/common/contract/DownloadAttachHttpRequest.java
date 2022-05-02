package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:26 PM
 */

@Getter
public class DownloadAttachHttpRequest extends BaseHttpRequest {
    
    @JsonProperty("link")
    private Integer attachId;
}
