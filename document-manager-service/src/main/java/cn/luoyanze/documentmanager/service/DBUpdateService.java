package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.*;
import cn.luoyanze.documentmanager.exception.CustomException;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/20 8:48 PM
 */

public interface DBUpdateService {

    UpdateFileHttpResponse updateFile(UpdateFileHttpRequest request);

    DeleteAttachHttpResponse deleteAttach(DeleteAttachHttpRequest request);

    DeleteTableItemHttpResponse deleteTableItem(DeleteTableItemHttpRequest request) throws Exception;
}
