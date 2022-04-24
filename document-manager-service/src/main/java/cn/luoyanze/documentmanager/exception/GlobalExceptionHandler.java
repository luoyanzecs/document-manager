package cn.luoyanze.documentmanager.exception;

import cn.luoyanze.common.contract.common.ResponseHead;
import org.jooq.tools.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 10:39 PM
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            TestException.class,
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







