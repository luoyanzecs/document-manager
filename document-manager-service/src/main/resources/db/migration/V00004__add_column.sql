use `document_manager`;
alter table S1_USER add `isDel` INT not null default 0 comment '0表示正常， 1为删除';
alter table S1_OPERATE add `isDel` INT not null default 0 comment '0表示正常， 1为删除';
alter table S1_DOC add `isDel` INT not null default 0 comment '0表示正常， 1为删除';
alter table S1_NOTICE add `isDel` INT not null default 0 comment '0表示正常， 1为删除';
alter table S1_COMMENT add `isDel` INT not null default 0 comment '0表示正常， 1为删除';
