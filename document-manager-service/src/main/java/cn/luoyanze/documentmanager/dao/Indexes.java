/*
 * This file is generated by jOOQ.
 */
package cn.luoyanze.documentmanager.dao;


import cn.luoyanze.documentmanager.dao.tables.S1AttachTB;
import cn.luoyanze.documentmanager.dao.tables.S1DirTB;
import cn.luoyanze.documentmanager.dao.tables.S1DocTB;
import cn.luoyanze.documentmanager.dao.tables.S1NodeTB;
import cn.luoyanze.documentmanager.dao.tables.S1OperateTB;
import cn.luoyanze.documentmanager.dao.tables.S1UserTB;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables in document_manager.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index S1_DIR_BU_ID = Internal.createIndex(DSL.name("bu_id"), S1DirTB.S1_DIR, new OrderField[] { S1DirTB.S1_DIR.BU_ID }, false);
    public static final Index S1_USER_BU_ID = Internal.createIndex(DSL.name("bu_id"), S1UserTB.S1_USER, new OrderField[] { S1UserTB.S1_USER.BU_ID }, false);
    public static final Index S1_DOC_DIR_ID = Internal.createIndex(DSL.name("dir_id"), S1DocTB.S1_DOC, new OrderField[] { S1DocTB.S1_DOC.DIR_ID }, false);
    public static final Index S1_NODE_DOC_ID = Internal.createIndex(DSL.name("doc_id"), S1NodeTB.S1_NODE, new OrderField[] { S1NodeTB.S1_NODE.DOC_ID }, false);
    public static final Index S1_OPERATE_DOC_ID = Internal.createIndex(DSL.name("doc_id"), S1OperateTB.S1_OPERATE, new OrderField[] { S1OperateTB.S1_OPERATE.DOC_ID }, false);
    public static final Index S1_ATTACH_DOC_PRIMARY_ID = Internal.createIndex(DSL.name("doc_primary_id"), S1AttachTB.S1_ATTACH, new OrderField[] { S1AttachTB.S1_ATTACH.DOC_PRIMARY_ID }, false);
    public static final Index S1_DOC_LAST_UPDATE_USER_ID = Internal.createIndex(DSL.name("last_update_user_id"), S1DocTB.S1_DOC, new OrderField[] { S1DocTB.S1_DOC.LAST_UPDATE_USER_ID }, false);
    public static final Index S1_DOC_USER_ID = Internal.createIndex(DSL.name("user_id"), S1DocTB.S1_DOC, new OrderField[] { S1DocTB.S1_DOC.USER_ID }, false);
    public static final Index S1_OPERATE_USER_ID = Internal.createIndex(DSL.name("user_id"), S1OperateTB.S1_OPERATE, new OrderField[] { S1OperateTB.S1_OPERATE.USER_ID }, false);
    public static final Index S1_ATTACH_USER_PRIMARY_ID = Internal.createIndex(DSL.name("user_primary_id"), S1AttachTB.S1_ATTACH, new OrderField[] { S1AttachTB.S1_ATTACH.USER_PRIMARY_ID }, false);
}
