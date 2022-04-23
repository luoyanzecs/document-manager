package cn.luoyanze.documentmanager.controller;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.service.DBSelectService;
import cn.luoyanze.documentmanager.service.LoginApiService;
import cn.luoyanze.documentmanager.service.ElasticSearchService;
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
    public LoginHttpResponse execute(@RequestBody LoginHttpRequset request) {
        return loginApiService.execute(request);
    }

    @PostMapping(value = "/notice")
    @ResponseBody
    public NoticeHttpResponse execute(@RequestBody NoticeHttpRequset request) {
        return dbSelectService.selectNotice(request);
    }

    @PostMapping(value = "/search")
    @ResponseBody
    public SearchHttpResponse execute(@RequestBody SearchHttpRequest request) {
        return elasticSearchService.execute(request);
    }

    /**
     * 返回部门列表
     */
    @PostMapping(value = "/getbu")
    @ResponseBody
    public GetBuHttpResponse execute(@RequestBody GetBuHttpRequest request) {
        return dbSelectService.selectAllBu(request);
    }
}
