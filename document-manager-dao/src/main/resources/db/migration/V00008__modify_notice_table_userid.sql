use `document_manager`;

alter table S1_NOTICE
    add user_id int not null comment '关联用户表';


alter table S1_NOTICE
    add constraint S1_NOTICE_S1_USER_primary_id_fk
        foreign key (user_id) references S1_USER (primary_id);

