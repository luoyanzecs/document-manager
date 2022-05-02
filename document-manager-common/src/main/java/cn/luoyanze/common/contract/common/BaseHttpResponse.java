package cn.luoyanze.common.contract.common;

import cn.luoyanze.common.context.TraceContext;
import cn.luoyanze.common.model.HeadStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/29 8:22 PM
 */

@Data
public abstract class BaseHttpResponse {

    @JsonIgnore
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseHttpResponse.class);

    @JsonProperty("head")
    private ResponseHead head;


    public ResponseEntity<BaseHttpResponse> toResponse() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            TraceContext.setResponse(objectMapper.writeValueAsString(this));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseEntity
                .status(HeadStatus.getHttpStatus(head))
                .body(this);
    }
}
