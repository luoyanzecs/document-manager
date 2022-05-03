package cn.luoyanze.documentmanager.service.service;

import cn.luoyanze.documentmanager.common.contract.FilterSearchHttpRequest;
import cn.luoyanze.documentmanager.common.contract.FilterSearchHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/15 12:31 AM
 */

public interface FilterSearchService {

    FilterSearchHttpResponse execute(FilterSearchHttpRequest request);
}
