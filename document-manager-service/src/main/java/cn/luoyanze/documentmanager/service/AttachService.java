package cn.luoyanze.documentmanager.service;

import cn.luoyanze.common.contract.AddAttachHttpResponse;
import cn.luoyanze.common.contract.DownloadAttachHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:21 PM
 */

public interface AttachService {

    AddAttachHttpResponse upload(MultipartFile file, Integer doc, RequestHead head) throws Exception;

    Object download(DownloadAttachHttpRequest request) throws Exception;
}
