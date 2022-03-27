package cn.luoyanze.documentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/13 4:35 PM
 */

@Controller
@RequestMapping(value = "api/user")
public class UserController {
    @PostMapping("/menu")
    @ResponseBody
    public String executeMenu() {
        return "";
    }

    @PostMapping("/comment")
    @ResponseBody
    public String executeComment() {
        return "";
    }

    @PostMapping("/file")
    @ResponseBody
    public String executeFile() {
        return "";
    }
}
