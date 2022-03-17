package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.service.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/13 4:35 PM
 */

@Controller
public class UserController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test() {
        Test test = new Test();
        return test.test();
    }
}
