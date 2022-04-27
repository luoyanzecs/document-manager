package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.AddAttachHttpResponse;
import cn.luoyanze.common.contract.DownloadAttachHttpRequest;
import cn.luoyanze.common.contract.common.RequestHead;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.dao.tables.pojos.S1AttachBO;
import cn.luoyanze.documentmanager.dao.tables.records.S1AttachRecord;
import cn.luoyanze.documentmanager.exception.CustomException;
import cn.luoyanze.documentmanager.service.AttachService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static cn.luoyanze.common.model.HeadStatus.*;
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

    @Value("${cn.luoyanze.upload.location}")
    private String location;

    private final DSLContext dao;

    public AttachServiceImpl(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public AddAttachHttpResponse upload(MultipartFile file, Integer docId, RequestHead head) {
        AddAttachHttpResponse resp = new AddAttachHttpResponse();
        String name = file.getOriginalFilename();

        // TODO: 重名解决
        List<String> names = dao.select(S1_ATTACH.NAME).from(S1_ATTACH).fetchInto(String.class);


        S1AttachRecord record = new S1AttachRecord();
        record.setDocPrimaryId(docId);
        record.setName(name);
        record.setTime(LocalDateTime.now());
        record.setSize(file.getSize());
        record.setUserPrimaryId(head.getUserId());

        S1AttachRecord res = dao.insertInto(S1_ATTACH).set(record)
                .returning(S1_ATTACH.PRIMARY_ID)
                .fetchOne();

        Optional.ofNullable(res)
                .map(S1AttachRecord::getPrimaryId)
                .ifPresentOrElse(
                        it -> {
                            try {
                                Path path = Paths.get(location, it.toString());
                                Files.copy(file.getInputStream(), path);
                                resp.setHead(new ResponseHead(SUCCESS));
                                resp.setAttach(
                                        new AddAttachHttpResponse.Attach(name, it)
                                );
                            } catch (IOException e) {
                                LOGGER.error(e.getMessage(), e);
                                resp.setHead(new ResponseHead(UPLOADER_FAIL));
                            }
                        },
                        () -> resp.setHead(new ResponseHead(UPLOADER_FAIL))
                );

        return resp;
    }

    @Override
    public Object download(DownloadAttachHttpRequest request) throws CustomException {
        try {
            S1AttachBO attach = dao.selectFrom(S1_ATTACH)
                    .where(S1_ATTACH.PRIMARY_ID.eq(request.getAttachId()))
                    .and(S1_ATTACH.ISDEL.eq(0))
                    .fetchOneInto(S1AttachBO.class);

            if (attach == null) {
                throw new CustomException("", FILE_NOT_EXISIT);
            }

            String downloadFileName = new String(attach.getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

            File file = ResourceUtils.getFile(location + attach.getPrimaryId());

            InputStream inputStream = new FileInputStream(file);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Disposition", "attachment;filename=" + downloadFileName)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(inputStream.readAllBytes());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new CustomException("该文件不存在", FILE_NOT_EXISIT);
        }
    }
}
