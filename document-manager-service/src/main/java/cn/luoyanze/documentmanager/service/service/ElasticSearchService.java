package cn.luoyanze.documentmanager.service.service;

import cn.luoyanze.documentmanager.common.contract.SearchHttpRequest;
import cn.luoyanze.documentmanager.common.contract.SearchHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:47 AM
 */

public interface ElasticSearchService {

    SearchHttpResponse execute(SearchHttpRequest request);
}
