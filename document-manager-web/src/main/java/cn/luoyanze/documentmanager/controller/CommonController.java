package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.service.DBSelectService;
import cn.luoyanze.documentmanager.service.LoginApiService;
import cn.luoyanze.documentmanager.service.ElasticSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/3/27 11:13 AM
 */

@RestController
@RequestMapping(value = "api")
public class CommonController {

    private final LoginApiService loginApiService;
    private final ElasticSearchService elasticSearchService;
    private final DBSelectService dbSelectService;

    public CommonController(LoginApiService loginApiService, ElasticSearchService elasticSearchService, DBSelectService dbSelectService) {
        this.loginApiService = loginApiService;
        this.dbSelectService = dbSelectService;
        this.elasticSearchService = elasticSearchService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<LoginHttpResponse> execute(@RequestBody LoginHttpRequset request) throws Exception {
        LoginHttpResponse resp = loginApiService.execute(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    @PostMapping(value = "/notice")
    @ResponseBody
    public ResponseEntity<NoticeHttpResponse> execute(@RequestBody NoticeHttpRequset request) {
        NoticeHttpResponse resp = dbSelectService.selectNotice(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    @PostMapping(value = "/search")
    @ResponseBody
    public ResponseEntity<SearchHttpResponse> execute(@RequestBody SearchHttpRequest request) {
        SearchHttpResponse resp = elasticSearchService.execute(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }

    /**
     * 返回部门列表
     */
    @PostMapping(value = "/getbu")
    @ResponseBody
    public ResponseEntity<GetBuHttpResponse> execute(@RequestBody GetBuHttpRequest request) {
        GetBuHttpResponse resp =  dbSelectService.selectAllBu(request);
        return ResponseEntity
                .status(HeadStatus.getHttpStatus(resp.getHead()))
                .body(resp);
    }
}
