use `document_manager`;

create table S1_NODE
(
    `uuid`       char(48)      not null comment 'uuid, 由前端生成',
    `style`      varchar(1024) comment 'dom样式',
    `class`      varchar(1024) null comment 'class',
    `attribute`  varchar(1024) null comment '其他的attribute，json格式，map接收',
    `tag`        char(48)      not null comment 'html标签',
    `type`       char(12)      not null comment '节点类型',
    `parentUUID` char(48)      null comment '父节点id',
    `index`      char(255)     not null comment '层级索引',
    `text`       text          null comment '文本内容',
    `hash`       char(32)      not null comment 'hash值',
    `doc_id`     int           not null comment '文件id',
    `is_del`     int           not null default 0 comment '是否删除 1为删除 0为未删除',
    `last_time`  datetime      not null comment '上次修改时间',
    PRIMARY KEY (uuid),
    FOREIGN KEY (doc_id) REFERENCES S1_DOC (primary_id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;