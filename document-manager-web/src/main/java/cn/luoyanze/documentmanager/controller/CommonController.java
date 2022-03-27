package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.contract.LoginHttpRequset;
import cn.luoyanze.documentmanager.contract.LoginHttpResponse;
import cn.luoyanze.documentmanager.contract.NoticeHttpRequset;
import cn.luoyanze.documentmanager.contract.NoticeHttpResponse;
import cn.luoyanze.documentmanager.service.LoginApiService;
import cn.luoyanze.documentmanager.service.NoticeApiService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:13 AM
 */

@RestController
@RequestMapping(value = "api")
public class CommonController {

    private final LoginApiService loginApiService;
    private final NoticeApiService noticeApiService;

    public CommonController(LoginApiService loginApiService, NoticeApiService noticeApiService) {
        this.loginApiService = loginApiService;
        this.noticeApiService = noticeApiService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public LoginHttpResponse executeLogin(@RequestBody LoginHttpRequset request) {
        return loginApiService.excute(request);
    }

    @PostMapping(value = "/notice")
    @ResponseBody
    public NoticeHttpResponse executeNotice(@RequestBody NoticeHttpRequset request) {
        return noticeApiService.excute(request);
    }
}
