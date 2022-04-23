use `document_manager`;
CREATE TABLE `S1_BU`
(
    `primary_id`      INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `name`            CHAR(16) NOT NULL COMMENT '部门名称',
    PRIMARY KEY (primary_id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;