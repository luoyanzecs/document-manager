package cn.luoyanze.documentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:11 AM
 */

@Controller
@RequestMapping(value = "api/admin")
public class AdminController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void executeUsers() {

    }

    @RequestMapping(value = "files", method = RequestMethod.POST)
    @ResponseBody
    public void executeFiles() {

    }

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseBody
    public void executeRecords() {

    }

    @RequestMapping(value = "/notices", method = RequestMethod.POST)
    @ResponseBody
    public void executeNotices() {

    }

}
