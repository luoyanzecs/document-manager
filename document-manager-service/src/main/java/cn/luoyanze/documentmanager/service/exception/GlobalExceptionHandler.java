package cn.luoyanze.documentmanager.service.exception;

import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import org.jooq.tools.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 10:39 PM
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            CustomException.class
    })
    @ResponseBody
    public ResponseHead execute(GlobalException e) {
        ResponseHead head = new ResponseHead(e.getStatus());
        if (StringUtils.isEmpty(e.getMessage())) {
            return head;
        }
        String allMsg = head.getMessage() + " : " + e.getMessage();
        head.setMessage(allMsg);
        return head;
    }

}







