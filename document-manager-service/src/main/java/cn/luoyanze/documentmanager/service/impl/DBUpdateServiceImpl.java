package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.service.DBUpdateService;
import org.springframework.stereotype.Service;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 9:55 PM
 */

/**
 * 一些更改操作
 */
@Service
public class DBUpdateServiceImpl implements DBUpdateService {

    @Override
    public UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request) {
        return null;
    }

    /**
     * 删除附件， 只需要把doc数据库的附件链接删除即可
     */
    @Override
    public DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request) {
        return null;
    }

    @Override
    public DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) {
        return null;
    }
}
