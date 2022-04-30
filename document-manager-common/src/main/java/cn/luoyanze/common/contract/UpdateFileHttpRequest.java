package cn.luoyanze.common.contract;

import cn.luoyanze.common.contract.common.BaseHttpRequest;
import cn.luoyanze.common.contract.entity.DomNode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/9 10:09 PM
 */

@Getter
public class UpdateFileHttpRequest extends BaseHttpRequest {

    /**
     * json 格式内容
     */
    private String jsonValue;

    /**
     * 文件id
     */
    private Integer fileId;

    @JsonProperty("deleteNodes")
    private List<String> deleteNodes;

    @JsonProperty("updateNodes")
    private List<DomNode> updateNodes;

    @JsonProperty("newNodes")
    private List<DomNode> newNodes;

}
