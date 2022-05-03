package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import cn.luoyanze.documentmanager.common.contract.entity.DomNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/9 10:09 PM
 */

@Getter
public class UpdateFileHttpRequest extends BaseHttpRequest {

    /**
     * 文件id
     */
    private Integer fileId;

    @JsonProperty("deleteNodes")
    private List<String> deleteIds;

    @JsonProperty("updateNodes")
    private List<DomNode> updateNodes;

    @JsonProperty("newNodes")
    private List<DomNode> newNodes;

}
