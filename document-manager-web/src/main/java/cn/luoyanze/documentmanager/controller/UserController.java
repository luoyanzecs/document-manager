package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.common.contract.CreateFileHttpRequest;
import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.contract.common.RequestHead;
import cn.luoyanze.documentmanager.exception.AttachUploadException;
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
    private final AttachService attachService;

    public UserController(DBUpdateService dbUpdateService, DBSelectService dbSelectService, DBInsertService dbInsertService, AttachService attachService) {
        this.dbUpdateService = dbUpdateService;
        this.dbSelectService = dbSelectService;
        this.dbInsertService = dbInsertService;
        this.attachService = attachService;
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
    public UpdateFileHttpResponse execute(@RequestBody UpdateFileHttpRequest request) {
        return dbUpdateService.updateFile(request);
    }

    @PostMapping("/createFile")
    @ResponseBody
    public CreateFileHttpResponse execute(@RequestBody CreateFileHttpRequest request) throws Exception {
        return dbInsertService.insertNewFile(request);
    }

    @PostMapping("/leaveMessage")
    @ResponseBody
    public LeaveMessageHttpResponse execute(@RequestBody LeaveMessageHttpRequest request) throws Exception {
        return dbInsertService.insertNewComment(request);
    }

    @PostMapping("/uploadAttach")
    @ResponseBody
    public AddAttachHttpResponse execute(
            @RequestParam("file")MultipartFile file,
            @RequestParam("docId")Integer docId,
            @RequestParam("head")RequestHead head) throws Exception {
        return attachService.upload(file, docId, head);
    }

    @PostMapping("/downloadAttach")
    @ResponseBody
    public Object execute(@RequestBody DownloadAttachHttpRequest request) throws Exception {
        return attachService.download(request);
    }

    @PostMapping("/deleteAttach")
    @ResponseBody
    public DeleteAttachHttpResponse execute(@RequestBody DeleteAttachHttpRequest request) {
        return dbUpdateService.deleteAttach(request);
    }

}
