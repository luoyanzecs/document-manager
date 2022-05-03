use `document_manager`;
CREATE TABLE `S1_TRACE`
(
    `uuid`           char(32)     not null COMMENT 'traceid',
    `user_id`        INT          not null comment '用户id',
    `url`            varchar(255) not null comment '请求路径',
    `store_request`  text         null comment '请求body',
    `store_response` text         null comment '响应body',
    `request_time`   datetime     null comment '请求时间',
    `response_time`  datetime     null comment '响应时间',
    `internal`       int          null comment '处理总时间',
    PRIMARY KEY (uuid),
    FOREIGN KEY (user_id) REFERENCES S1_USER (primary_id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;