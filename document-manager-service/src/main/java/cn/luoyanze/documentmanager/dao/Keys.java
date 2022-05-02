/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao;


import cn.luoyanze.documentmanager.dao.tables.S1AttachTB;
import cn.luoyanze.documentmanager.dao.tables.S1BuTB;
import cn.luoyanze.documentmanager.dao.tables.S1CommentTB;
import cn.luoyanze.documentmanager.dao.tables.S1DirTB;
import cn.luoyanze.documentmanager.dao.tables.S1DocTB;
import cn.luoyanze.documentmanager.dao.tables.S1LogTB;
import cn.luoyanze.documentmanager.dao.tables.S1NodeTB;
import cn.luoyanze.documentmanager.dao.tables.S1NoticeTB;
import cn.luoyanze.documentmanager.dao.tables.S1OperateTB;
import cn.luoyanze.documentmanager.dao.tables.S1UserTB;
import cn.luoyanze.documentmanager.dao.tables.records.S1AttachRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1BuRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1CommentRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1DirRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1DocRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1LogRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1NodeRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1NoticeRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1OperateRecord;
import cn.luoyanze.documentmanager.dao.tables.records.S1UserRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * document_manager.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<S1AttachRecord> KEY_S1_ATTACH_PRIMARY = Internal.createUniqueKey(S1AttachTB.S1_ATTACH, DSL.name("KEY_S1_ATTACH_PRIMARY"), new TableField[] { S1AttachTB.S1_ATTACH.PRIMARY_ID }, true);
    public static final UniqueKey<S1BuRecord> KEY_S1_BU_PRIMARY = Internal.createUniqueKey(S1BuTB.S1_BU, DSL.name("KEY_S1_BU_PRIMARY"), new TableField[] { S1BuTB.S1_BU.PRIMARY_ID }, true);
    public static final UniqueKey<S1CommentRecord> KEY_S1_COMMENT_PRIMARY = Internal.createUniqueKey(S1CommentTB.S1_COMMENT, DSL.name("KEY_S1_COMMENT_PRIMARY"), new TableField[] { S1CommentTB.S1_COMMENT.PRIMARY_ID }, true);
    public static final UniqueKey<S1DirRecord> KEY_S1_DIR_PRIMARY = Internal.createUniqueKey(S1DirTB.S1_DIR, DSL.name("KEY_S1_DIR_PRIMARY"), new TableField[] { S1DirTB.S1_DIR.PRIMARY_ID }, true);
    public static final UniqueKey<S1DocRecord> KEY_S1_DOC_PRIMARY = Internal.createUniqueKey(S1DocTB.S1_DOC, DSL.name("KEY_S1_DOC_PRIMARY"), new TableField[] { S1DocTB.S1_DOC.PRIMARY_ID }, true);
    public static final UniqueKey<S1LogRecord> KEY_S1_LOG_PRIMARY = Internal.createUniqueKey(S1LogTB.S1_LOG, DSL.name("KEY_S1_LOG_PRIMARY"), new TableField[] { S1LogTB.S1_LOG.LOGID }, true);
    public static final UniqueKey<S1NodeRecord> KEY_S1_NODE_PRIMARY = Internal.createUniqueKey(S1NodeTB.S1_NODE, DSL.name("KEY_S1_NODE_PRIMARY"), new TableField[] { S1NodeTB.S1_NODE.UUID }, true);
    public static final UniqueKey<S1NoticeRecord> KEY_S1_NOTICE_PRIMARY = Internal.createUniqueKey(S1NoticeTB.S1_NOTICE, DSL.name("KEY_S1_NOTICE_PRIMARY"), new TableField[] { S1NoticeTB.S1_NOTICE.PRIMARY_ID }, true);
    public static final UniqueKey<S1OperateRecord> KEY_S1_OPERATE_PRIMARY = Internal.createUniqueKey(S1OperateTB.S1_OPERATE, DSL.name("KEY_S1_OPERATE_PRIMARY"), new TableField[] { S1OperateTB.S1_OPERATE.PRIMARY_ID }, true);
    public static final UniqueKey<S1UserRecord> KEY_S1_USER_PRIMARY = Internal.createUniqueKey(S1UserTB.S1_USER, DSL.name("KEY_S1_USER_PRIMARY"), new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<S1AttachRecord, S1DocRecord> S1_ATTACH_IBFK_1 = Internal.createForeignKey(S1AttachTB.S1_ATTACH, DSL.name("s1_attach_ibfk_1"), new TableField[] { S1AttachTB.S1_ATTACH.DOC_PRIMARY_ID }, Keys.KEY_S1_DOC_PRIMARY, new TableField[] { S1DocTB.S1_DOC.PRIMARY_ID }, true);
    public static final ForeignKey<S1AttachRecord, S1UserRecord> S1_ATTACH_IBFK_2 = Internal.createForeignKey(S1AttachTB.S1_ATTACH, DSL.name("s1_attach_ibfk_2"), new TableField[] { S1AttachTB.S1_ATTACH.USER_PRIMARY_ID }, Keys.KEY_S1_USER_PRIMARY, new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);
    public static final ForeignKey<S1DirRecord, S1BuRecord> S1_DIR_IBFK_1 = Internal.createForeignKey(S1DirTB.S1_DIR, DSL.name("s1_dir_ibfk_1"), new TableField[] { S1DirTB.S1_DIR.BU_ID }, Keys.KEY_S1_BU_PRIMARY, new TableField[] { S1BuTB.S1_BU.PRIMARY_ID }, true);
    public static final ForeignKey<S1DocRecord, S1UserRecord> S1_DOC_IBFK_1 = Internal.createForeignKey(S1DocTB.S1_DOC, DSL.name("s1_doc_ibfk_1"), new TableField[] { S1DocTB.S1_DOC.USER_ID }, Keys.KEY_S1_USER_PRIMARY, new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);
    public static final ForeignKey<S1DocRecord, S1DirRecord> S1_DOC_IBFK_2 = Internal.createForeignKey(S1DocTB.S1_DOC, DSL.name("s1_doc_ibfk_2"), new TableField[] { S1DocTB.S1_DOC.DIR_ID }, Keys.KEY_S1_DIR_PRIMARY, new TableField[] { S1DirTB.S1_DIR.PRIMARY_ID }, true);
    public static final ForeignKey<S1DocRecord, S1UserRecord> S1_DOC_IBFK_3 = Internal.createForeignKey(S1DocTB.S1_DOC, DSL.name("s1_doc_ibfk_3"), new TableField[] { S1DocTB.S1_DOC.LAST_UPDATE_USER_ID }, Keys.KEY_S1_USER_PRIMARY, new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);
    public static final ForeignKey<S1NodeRecord, S1DocRecord> S1_NODE_IBFK_1 = Internal.createForeignKey(S1NodeTB.S1_NODE, DSL.name("s1_node_ibfk_1"), new TableField[] { S1NodeTB.S1_NODE.DOC_ID }, Keys.KEY_S1_DOC_PRIMARY, new TableField[] { S1DocTB.S1_DOC.PRIMARY_ID }, true);
    public static final ForeignKey<S1NoticeRecord, S1UserRecord> S1_NOTICE_S1_USER_PRIMARY_ID_FK = Internal.createForeignKey(S1NoticeTB.S1_NOTICE, DSL.name("S1_NOTICE_S1_USER_primary_id_fk"), new TableField[] { S1NoticeTB.S1_NOTICE.USER_ID }, Keys.KEY_S1_USER_PRIMARY, new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);
    public static final ForeignKey<S1OperateRecord, S1UserRecord> S1_OPERATE_IBFK_1 = Internal.createForeignKey(S1OperateTB.S1_OPERATE, DSL.name("s1_operate_ibfk_1"), new TableField[] { S1OperateTB.S1_OPERATE.USER_ID }, Keys.KEY_S1_USER_PRIMARY, new TableField[] { S1UserTB.S1_USER.PRIMARY_ID }, true);
    public static final ForeignKey<S1OperateRecord, S1DocRecord> S1_OPERATE_IBFK_2 = Internal.createForeignKey(S1OperateTB.S1_OPERATE, DSL.name("s1_operate_ibfk_2"), new TableField[] { S1OperateTB.S1_OPERATE.DOC_ID }, Keys.KEY_S1_DOC_PRIMARY, new TableField[] { S1DocTB.S1_DOC.PRIMARY_ID }, true);
    public static final ForeignKey<S1UserRecord, S1BuRecord> S1_USER_IBFK_1 = Internal.createForeignKey(S1UserTB.S1_USER, DSL.name("s1_user_ibfk_1"), new TableField[] { S1UserTB.S1_USER.BU_ID }, Keys.KEY_S1_BU_PRIMARY, new TableField[] { S1BuTB.S1_BU.PRIMARY_ID }, true);
}
