package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 9:55 PM
 */

@Service
public class DBUpdateServiceImpl implements DBUpdateService {

    @Override
    public UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request) {
        return null;
    }

    @Override
    public DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request) {
        return null;
    }

    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) {
        return null;
    }
}
