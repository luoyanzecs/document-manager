use
    `document_manager`;

create table S1_LOG
(
    `logId`         int(10)      not null auto_increment comment '日志ID',
    `className`     varchar(200) not null comment '类名',
    `methodName`    varchar(100) not null comment '方法名称',
    `exceptionName` varchar(155) not null comment '异常类型',
    `errMsg`        varchar(500) comment '错误信息',
    `stackTrace`    text comment '异常堆栈信息',
    `createTime`    datetime     not null comment '创建时间',
    PRIMARY KEY (logId)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;