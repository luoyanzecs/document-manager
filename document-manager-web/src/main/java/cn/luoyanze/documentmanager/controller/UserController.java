package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.common.contract.*;
import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import cn.luoyanze.documentmanager.common.contract.common.RequestHead;
import cn.luoyanze.documentmanager.service.service.AttachService;
import cn.luoyanze.documentmanager.service.service.DBInsertService;
import cn.luoyanze.documentmanager.service.service.DBSelectService;
import cn.luoyanze.documentmanager.service.service.DBUpdateService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody FileMenuHttpRequset request) {
        return dbSelectService.selectMenuByBu(request).toResponse();
    }

    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody FileCommentHttpRequset request) {
        return dbSelectService.selectFileComment(request).toResponse();
    }

    @PostMapping("/file")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody UserFileHttpRequset request) {
        return dbSelectService.selectFileById(request).toResponse();
    }

    @PostMapping("/updateFile")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody UpdateFileHttpRequest request) {
        return dbUpdateService.updateFile(request).toResponse();
    }

    @PostMapping("/createFile")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody CreateFileHttpRequest request) {
        return dbInsertService.insertNewFile(request).toResponse();
    }

    @PostMapping("/leaveMessage")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody LeaveMessageHttpRequest request) {
        return dbInsertService.insertNewComment(request).toResponse();
    }

    @PostMapping(value="/uploadAttach", consumes = {"multipart/form-data"})
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(
            @RequestPart("file") MultipartFile file,
            @RequestPart("docId") Integer docId,
            @RequestPart("head") RequestHead head) {

        return attachService.upload(file, docId, head).toResponse();
    }

    @PostMapping("/downloadAttach")
    @ResponseBody
    public Object execute(@RequestBody DownloadAttachHttpRequest request) throws Exception {
        return attachService.download(request);
    }

    @PostMapping("/deleteAttach")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody DeleteAttachHttpRequest request) {
        return dbUpdateService.deleteAttach(request).toResponse();
    }

}
