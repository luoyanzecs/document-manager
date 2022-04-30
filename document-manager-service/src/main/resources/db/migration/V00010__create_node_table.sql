use `document_manager`;

create table S1_NODE
(
    `primary_id` int      not null auto_increment comment '自增主键',
    `uuid`       char(48) not null comment 'uuid, 由前端生成',
    `style`      varchar(1024) comment 'dom样式',
    `tag`        char(48) comment 'html标签',
    `type`       char(12) comment '节点类型',
    `parentUUID` char(48) comment '父节点id',
    `index`      char(255) comment '层级索引',
    `childs`     varchar(2048) comment '子节点列表',
    `text`       text comment '文本内容',
    `hash`       char(32) comment 'hash值',
    `doc_id`     int      not null comment '文件id',
    `id_del`     int      not null default 0 comment '是否删除 1为删除 0为未删除',
    `last_time`  datetime comment '上次修改时间',
    PRIMARY KEY (primary_id),
    FOREIGN KEY (doc_id) REFERENCES S1_DOC (primary_id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;