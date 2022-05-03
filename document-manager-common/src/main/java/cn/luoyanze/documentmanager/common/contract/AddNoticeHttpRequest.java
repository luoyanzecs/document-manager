package cn.luoyanze.documentmanager.common.contract;

import cn.luoyanze.documentmanager.common.contract.common.BaseHttpRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/21 12:32 AM
 */


@Getter
public class AddNoticeHttpRequest extends BaseHttpRequest {

    private String text;

    private boolean isGlobal;

    private int type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expiredTime;

    private List<Integer> bu;

    private List<Integer> users;
}
