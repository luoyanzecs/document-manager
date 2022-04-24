use
`document_manager`;
CREATE TABLE `S1_USER`
(
    `primary_id`      INT      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `account`         CHAR(16) NOT NULL COMMENT '用户账号',
    `password`        CHAR(16) NOT NULL COMMENT '用户密码',
    `role`            CHAR(10) NOT NULL COMMENT '角色',
    `avatar`          CHAR(255) COMMENT '用户头像',
    `tel`             CHAR(16) COMMENT '电话',
    `email`           char(32) COMMENT '电邮',
    `last_login_time` DATETIME COMMENT '最近一次登录时间',
    `register_time`   DATETIME COMMENT '注册时间',
    `status`          INT      NOT NULL COMMENT '在职状态， 在职1， 不在职0',
    `bu`              CHAR(16) NOT NULL COMMENT '用户部门',
    `authority`       INT      NOT NULL COMMENT '权限等级',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `S1_DIR`
(
    `primary_id` INT      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `title`      TEXT     NOT NULL COMMENT '标题',
    `parent_id`  INT      NOT NULL COMMENT '上级目录ID',
    `bu`         CHAR(16) NOT NULL COMMENT '所属部门',
    `deep`       INT      NOT NULL COMMENT '目录层级',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;


CREATE TABLE `S1_DOC`
(
    `primary_id`          INT  NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `permission_bu`       CHAR(16) COMMENT '允许的部门',
    `authority`           INT COMMENT '允许的等级',
    `status`              INT  NOT NULL default 1 COMMENT '状态 0已删除， 1正常',
    `ctx`                 TEXT NOT NULL COMMENT '内容',
    `user_id`             INT  NOT NULL COMMENT '创建用户id',
    `last_update_time`    DATETIME COMMENT '最近修改时间登录时间',
    `title`               TEXT NOT NULL COMMENT '标题',
    `dir_id`              INT  NOT NULL COMMENT '上级目录ID',
    `last_update_user_id` INT  NOT NULL COMMENT '最近修改用户id',
    PRIMARY KEY (primary_id),
    FOREIGN KEY (user_id) REFERENCES S1_USER (primary_id),
    FOREIGN KEY (dir_id) REFERENCES S1_DIR (primary_id),
    FOREIGN KEY (last_update_user_id) REFERENCES S1_USER (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;


CREATE TABLE `S1_COMMENT`
(
    `primary_id`  INT           NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `doc_id`      INT           NOT NULL COMMENT '文章id',
    `user_id`     INT           NOT NULL COMMENT '用户id',
    `ctx`         VARCHAR(2048) NOT NULL COMMENT '评论内容',
    `create_time` DATETIME      NOT NULL COMMENT '评论创建时间',
    `parent_id`   INT           NOT NULL COMMENT '上级评论',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `S1_OPERATE`
(
    `primary_id` INT      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `type`       INT      NOT NULL COMMENT '操作类型',
    `time`       DATETIME NOT NULL COMMENT '操作时间',
    `doc_id`     INT      NOT NULL COMMENT '文章uuid',
    `user_id`    INT      NOT NULL COMMENT 'user uuid',
    `content`    TEXT COMMENT '内容保留字段',
    PRIMARY KEY (primary_id),
    FOREIGN KEY (user_id) REFERENCES S1_USER (primary_id),
    FOREIGN KEY (doc_id) REFERENCES S1_DOC (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `S1_NOTICE`
(
    `primary_id`   INT           NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `type`         INT           NOT NULL COMMENT '内容type',
    `content`      VARCHAR(1024) NOT NULL COMMENT '内容',
    `start_time`   DATETIME      NOT NULL COMMENT '起始时间',
    `end_time`     DATETIME      NOT NULL COMMENT '结束时间',
    `accept_users` VARCHAR(1024) COMMENT '接收用户列表 逗号分隔',
    `accept_bu`    VARCHAR(1024) COMMENT '接收部门列表, 逗号分隔',
    `is_global`    INT COMMENT '是否全局通知 1全局',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `S1_EXCEPTION`
(
    `primary_id` INT      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `time`       DATETIME NOT NULL COMMENT '时间',
    `type`       CHAR(10) NOT NULL COMMENT '类型',
    `ctx`        TEXT     NOT NULL COMMENT '内容',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;