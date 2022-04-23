package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.SearchHttpRequest;
import cn.luoyanze.common.contract.SearchHttpResponse;
import cn.luoyanze.documentmanager.service.ElasticSearchService;
import org.springframework.stereotype.Service;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:50 AM
 */

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Override
    public SearchHttpResponse execute(SearchHttpRequest request) {
        return null;
    }
}
