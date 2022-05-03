package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
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
