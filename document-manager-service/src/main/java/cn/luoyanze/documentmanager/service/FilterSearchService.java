package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.FilterSearchHttpRequest;
import cn.luoyanze.common.contract.FilterSearchHttpResponse;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/15 12:31 AM
 */

public interface FilterSearchService {

    FilterSearchHttpResponse execute(FilterSearchHttpRequest request);
}
