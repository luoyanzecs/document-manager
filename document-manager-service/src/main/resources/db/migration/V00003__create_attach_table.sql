use `document_manager`;
create table S1_ATTACH
(
    primary_id      int auto_increment not null comment '自增主键',
    doc_primary_id  int                not null comment '文件ID',
    link            varchar(1024)      not null comment '是否链接',
    name            varchar(1024)      not null comment '文件名',
    size            int                not null comment '文件大小',
    time            datetime           not null comment '上传时间',
    user_primary_id int                not null comment '用户id',
    isDel           int default 0      not null comment '是否删除',
    primary key (primary_id),
    FOREIGN KEY (doc_primary_id) REFERENCES S1_DOC (primary_id),
    FOREIGN KEY (user_primary_id) REFERENCES S1_USER (primary_id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;