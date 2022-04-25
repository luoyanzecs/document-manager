use `document_manager`;

insert into S1_BU(name)
values ('开发'), ('运营'), ('产品'), ('采购'), ('客服');

insert into
    S1_USER(account, password, role, avatar, tel, email, last_login_time, register_time, status, bu_id, authority)
values
       ('luoyanze', '12345678', '用户', '', '13333333333', '', NOW(), NOW(),  0, 1, 10),
       ('luoyanze', '12345678', '管理员', '', '13333333333', '', NOW(), NOW(),  0, 1, 10);

insert into S1_DIR(title, parent_id, bu_id, deep)
values ('root', 0, -1, 0)