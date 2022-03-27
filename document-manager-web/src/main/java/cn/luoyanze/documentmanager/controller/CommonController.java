package cn.luoyanze.documentmanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:13 AM
 */

@RestController
@RequestMapping(value = "api")
public class CommonController {

    @PostMapping(value = "/login")
    @ResponseBody
    public String executeLogin() {
        return "";
    }

    @PostMapping(value = "/notice")
    @ResponseBody
    public String executeNotice() {
        return "";
    }
}
