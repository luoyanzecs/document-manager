package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.service.DBInsertService;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import cn.luoyanze.documentmanager.service.FilterSearchService;
import org.springframework.http.ResponseEntity;
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

    private final FilterSearchService searchService;
    private final DBInsertService dbInsertService;
    private final DBUpdateService dbUpdateService;

    public AdminController(FilterSearchService searchService, DBInsertService dbInsertService, DBUpdateService dbUpdateService) {
        this.searchService = searchService;
        this.dbInsertService = dbInsertService;
        this.dbUpdateService = dbUpdateService;
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<FilterSearchHttpResponse> execute(@RequestBody FilterSearchHttpRequest request) {
        FilterSearchHttpResponse resp = searchService.execute(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddUserHttpResponse> execute(@RequestBody AddUserHttpRequest request) {
        AddUserHttpResponse resp = dbInsertService.insertNewUser(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    @RequestMapping(value = "/add/notice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddNoticeHttpResponse> execute(@RequestBody AddNoticeHttpRequest request) throws Exception {
        AddNoticeHttpResponse resp = dbInsertService.insertNewNotice(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DeleteTableItemHttpResponse> execute(@RequestBody DeleteTableItemHttpRequest request) throws Exception {
        DeleteTableItemHttpResponse resp =  dbUpdateService.deleteTableItem(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

}
