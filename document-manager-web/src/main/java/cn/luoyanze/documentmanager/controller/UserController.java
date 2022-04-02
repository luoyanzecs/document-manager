package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.contract.*;
import cn.luoyanze.documentmanager.service.UserCommentApiService;
import cn.luoyanze.documentmanager.service.UserFileApiService;
import cn.luoyanze.documentmanager.service.UserMenuApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/13 4:35 PM
 */

@Controller
@RequestMapping(value = "api/user")
public class UserController {

    private final UserCommentApiService userCommentApiService;
    private final UserFileApiService userFileApiService;
    private final UserMenuApiService userMenuApiService;

    public UserController(UserCommentApiService userCommentApiService, UserFileApiService userFileApiService, UserMenuApiService userMenuApiService) {
        this.userCommentApiService = userCommentApiService;
        this.userFileApiService = userFileApiService;
        this.userMenuApiService = userMenuApiService;
    }

    @PostMapping("/menu")
    @ResponseBody
    public FileMenuHttpResponse executeMenu(@RequestBody FileMenuHttpRequset request) {
        return userMenuApiService.excute(request);
    }

    @PostMapping("/comment")
    @ResponseBody
    public FileCommentHttpResponse executeComment(@RequestBody FileCommentHttpRequset request) {
        return userCommentApiService.excute(request);
    }

    @PostMapping("/file")
    @ResponseBody
    public UserFileHttpResponse executeFile(@RequestBody UserFileHttpRequset request) {
        return userFileApiService.excute(request);
    }
}
