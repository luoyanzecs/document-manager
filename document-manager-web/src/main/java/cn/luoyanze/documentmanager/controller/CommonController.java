package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.documentmanager.common.contract.GetBuHttpRequest;
import cn.luoyanze.documentmanager.common.contract.LoginHttpRequest;
import cn.luoyanze.documentmanager.common.contract.NoticeHttpRequset;
import cn.luoyanze.documentmanager.common.contract.SearchHttpRequest;
import cn.luoyanze.documentmanager.common.contract.common.BaseHttpResponse;
import cn.luoyanze.documentmanager.service.service.CheckHealthService;
import cn.luoyanze.documentmanager.service.service.DBSelectService;
import cn.luoyanze.documentmanager.service.service.LoginApiService;
import cn.luoyanze.documentmanager.service.service.ElasticSearchService;
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
    private final CheckHealthService checkHealthService;

    public CommonController(LoginApiService loginApiService, ElasticSearchService elasticSearchService, DBSelectService dbSelectService,CheckHealthService checkHealthService) {
        this.loginApiService = loginApiService;
        this.dbSelectService = dbSelectService;
        this.elasticSearchService = elasticSearchService;
        this.checkHealthService =checkHealthService;

    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody LoginHttpRequest request) throws Exception {
        return loginApiService.execute(request).toResponse();
    }

    @PostMapping(value = "/notice")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody NoticeHttpRequset request) {
        return dbSelectService.selectNotice(request).toResponse();
    }

    @PostMapping(value = "/search")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody SearchHttpRequest request) {
        return elasticSearchService.execute(request).toResponse();
    }

    /**
     * 返回部门列表
     */
    @PostMapping(value = "/getbu")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(@RequestBody GetBuHttpRequest request) {
        return dbSelectService.selectAllBu(request).toResponse();

    }

    /**
     * 返回服务器数据
     */
    @GetMapping(value = "/checkHealth")
    @ResponseBody
    public ResponseEntity<BaseHttpResponse> execute(){
        return  checkHealthService.checkHealth().toResponse();
    }
}
