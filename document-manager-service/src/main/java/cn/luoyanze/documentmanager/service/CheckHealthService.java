package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.CheckHealthHttpRequest;
import cn.luoyanze.common.contract.CheckHealthHttpResponse;

/**
 * @author
 * @date 2022/5/2 16:35
 */
public interface CheckHealthService {
    CheckHealthHttpResponse checkHealth();
}
