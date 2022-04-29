package cn.luoyanze.common.contract.common;

import cn.luoyanze.common.model.HeadStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.ResponseEntity;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/29 8:22 PM
 */

@Data
public abstract class BaseHttpResponse {

    @JsonProperty("head")
    private ResponseHead head;


    public ResponseEntity<BaseHttpResponse> toResponse() {
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(head))
                .body(this);
    }
}
