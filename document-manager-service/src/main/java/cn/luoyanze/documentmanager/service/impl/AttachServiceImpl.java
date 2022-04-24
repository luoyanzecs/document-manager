package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AddAttachHttpResponse;
import cn.luoyanze.common.contract.DownloadAttachHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1AttachBO;
import cn.luoyanze.documentmanager.exception.CustomException;
import cn.luoyanze.documentmanager.service.AttachService;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static cn.luoyanze.common.model.HeadStatus.FILE_NOT_EXISIT;
import static cn.luoyanze.common.model.HeadStatus.UPLOADER_FAIL;
import static cn.luoyanze.documentmanager.dao.Tables.S1_ATTACH;

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
    public AddAttachHttpResponse upload(MultipartFile file, Integer doc, RequestHead head) throws CustomException {
        AddAttachHttpResponse resp = new AddAttachHttpResponse();
        try {
            String name = file.getName();
            Path path = Paths.get(ResourceUtils.getURL("classpath:").getPath(), name);
            Files.copy(file.getInputStream(), path);

            S1AttachBO attach = new S1AttachBO();
            attach.setName(name);
            attach.setLink(path.toString());
            attach.setTime(LocalDateTime.now());
            attach.setSize(file.getSize());
            attach.setDocPrimaryId(doc);
            attach.setUserPrimaryId(head.getUserId());

            int execute = dao.insertInto(S1_ATTACH).values(attach).execute();
            if (execute == 0) {
                throw new CustomException("请检查您的网络环境", UPLOADER_FAIL);
            }
            resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
            return resp;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new CustomException("可能是文件写入磁盘异常", UPLOADER_FAIL);
        }
    }

    @Override
    public Object download(DownloadAttachHttpRequest request) throws CustomException {
        try {
            S1AttachBO attach = dao.selectFrom(S1_ATTACH)
                    .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                    .fetchOneInto(S1AttachBO.class);
            if (attach == null) {
                throw new CustomException("", FILE_NOT_EXISIT);
            }
            File file = ResourceUtils.getFile("classpath:" + attach.getName());
            InputStream inputStream = new FileInputStream(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Disposition", "attachment;filename=" + attach.getName())
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(inputStream);

        } catch (FileNotFoundException e) {
            throw new CustomException("该文件不存在", FILE_NOT_EXISIT);
        }
    }
}
