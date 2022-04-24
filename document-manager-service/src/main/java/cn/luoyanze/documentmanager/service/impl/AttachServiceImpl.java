package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AddAttachHttpResponse;
import cn.luoyanze.common.contract.DownloadAttachHttpRequest;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.service.AttachService;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/24 8:24 PM
 */

@Service
public class AttachServiceImpl implements AttachService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttachServiceImpl.class);

    private final DSLContext dao;

    public AttachServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AddAttachHttpResponse upload(MultipartFile file, Integer doc) {
        AddAttachHttpResponse resp = new AddAttachHttpResponse();
        try {
            //dao.insertInto()
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        resp.setHead(new ResponseHead(HeadStatus.UPLOADER_FAIL));
        return resp;
    }

    @Override
    public void download(DownloadAttachHttpRequest request) {

    }
}
