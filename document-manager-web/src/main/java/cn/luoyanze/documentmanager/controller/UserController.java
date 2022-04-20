package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.common.contract.CreateFileHttpRequest;
import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/13 4:35 PM
 */

@Controller
@RequestMapping(value = "api/user")
public class UserController {

    private final DBUpdateService dbUpdateService;
    private final DBSelectService dbSelectService;
    private final DBInsertService dbInsertService;

    public UserController(DBUpdateService dbUpdateService, DBSelectService dbSelectService, DBInsertService dbInsertService) {
        this.dbUpdateService = dbUpdateService;
        this.dbSelectService = dbSelectService;
        this.dbInsertService = dbInsertService;
    }

    @PostMapping("/menu")
    @ResponseBody
    public FileMenuHttpResponse execute(@RequestBody FileMenuHttpRequset request) {
        return dbSelectService.selectMenuByBu(request);
    }

    @PostMapping("/comment")
    @ResponseBody
    public FileCommentHttpResponse execute(@RequestBody FileCommentHttpRequset request) {
        return dbSelectService.selectFileComment(request);
    }

    @PostMapping("/file")
    @ResponseBody
    public UserFileHttpResponse execute(@RequestBody UserFileHttpRequset request) {
        return dbSelectService.selectFileById(request);
    }

    @PostMapping("/updateFile")
    @ResponseBody
    public UpdateFileHttpResponse excute(@RequestBody UpdateFileHttpRequest request) {
        return dbUpdateService.updateFile(request);
    }

    @PostMapping("/createFile")
    @ResponseBody
    public CreateFileHttpResponse excute(@RequestBody CreateFileHttpRequest request) {
        return dbInsertService.insertNewFile(request);
    }

    @PostMapping("/leaveMessage")
    @ResponseBody
    public LeaveMessageHttpResponse excute(@RequestBody LeaveMessageHttpRequest request) {
        return dbInsertService.insertNewComment(request);
    }

    // TODO: 文件上传
    @PostMapping("/uploadAttach")
    @ResponseBody
    public UpdateFileHttpResponse excute(@RequestParam("file") MultipartFile file) {
        return null;
    }

    // TODO: 文件下载
    @PostMapping("/downloadAttach")
    @ResponseBody
    public UpdateFileHttpResponse excute3() {
        return null;
    }

    @PostMapping("/deleteAttach")
    @ResponseBody
    public DeleteAttachHttpResponse excute(@RequestBody DeleteAttachHttpRequest request) {
        return dbUpdateService.deleteAttach(request);
    }

}
