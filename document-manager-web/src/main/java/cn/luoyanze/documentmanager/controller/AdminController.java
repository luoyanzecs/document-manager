package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.contract.*;
import cn.luoyanze.documentmanager.service.AdminFilesApiService;
import cn.luoyanze.documentmanager.service.AdminNoticesApiService;
import cn.luoyanze.documentmanager.service.AdminRecordsApiService;
import cn.luoyanze.documentmanager.service.AdminUsersApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final AdminFilesApiService adminFilesApiService;
    private final AdminNoticesApiService adminNoticesApiService;
    private final AdminRecordsApiService adminRecordsApiService;
    private final AdminUsersApiService adminUsersApiService;

    public AdminController(AdminFilesApiService adminFilesApiService, AdminNoticesApiService adminNoticesApiService, AdminRecordsApiService adminRecordsApiService, AdminUsersApiService adminUsersApiService) {
        this.adminFilesApiService = adminFilesApiService;
        this.adminNoticesApiService = adminNoticesApiService;
        this.adminRecordsApiService = adminRecordsApiService;
        this.adminUsersApiService = adminUsersApiService;
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public AdminUsersHttpResponse executeUsers(@RequestBody AdminUsersHttpRequest request) {
        return adminUsersApiService.execute(request);
    }

    @RequestMapping(value = "/files", method = RequestMethod.POST)
    @ResponseBody
    public AdminFilesHttpResponse executeFiles(@RequestBody AdminFilesHttpRequest request) {
        return adminFilesApiService.execute(request);
    }

    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseBody
    public AdminRecordsHttpResponse executeRecords(@RequestBody AdminRecordsHttpRequset requset) {
        return adminRecordsApiService.execute(requset);
    }

    @RequestMapping(value = "/notices", method = RequestMethod.POST)
    @ResponseBody
    public AdminNoticesHttpResponse executeNotices(@RequestBody AdminNoticesHttpRequest request) {
        return adminNoticesApiService.execute(request);
    }

}
