package cn.luoyanze.documentmanager.service.service;

import cn.luoyanze.documentmanager.common.contract.AddAttachHttpResponse;
import cn.luoyanze.documentmanager.common.contract.DownloadAttachHttpRequest;
import cn.luoyanze.documentmanager.common.contract.common.RequestHead;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:21 PM
 */

public interface AttachService {

    AddAttachHttpResponse upload(MultipartFile file, Integer doc, RequestHead head);

    Object download(DownloadAttachHttpRequest request) throws Exception;
}
