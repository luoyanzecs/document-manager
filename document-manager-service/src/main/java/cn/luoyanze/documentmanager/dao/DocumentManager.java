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

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DocumentManager extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>document_manager</code>
     */
    public static final DocumentManager DOCUMENT_MANAGER = new DocumentManager();

    /**
     * The table <code>document_manager.S1_ATTACH</code>.
     */
    public final S1AttachTB S1_ATTACH = S1AttachTB.S1_ATTACH;

    /**
     * The table <code>document_manager.S1_BU</code>.
     */
    public final S1BuTB S1_BU = S1BuTB.S1_BU;

    /**
     * The table <code>document_manager.S1_COMMENT</code>.
     */
    public final S1CommentTB S1_COMMENT = S1CommentTB.S1_COMMENT;

    /**
     * The table <code>document_manager.S1_DIR</code>.
     */
    public final S1DirTB S1_DIR = S1DirTB.S1_DIR;

    /**
     * The table <code>document_manager.S1_DOC</code>.
     */
    public final S1DocTB S1_DOC = S1DocTB.S1_DOC;

    /**
     * The table <code>document_manager.S1_LOG</code>.
     */
    public final S1LogTB S1_LOG = S1LogTB.S1_LOG;

    /**
     * The table <code>document_manager.S1_NODE</code>.
     */
    public final S1NodeTB S1_NODE = S1NodeTB.S1_NODE;

    /**
     * The table <code>document_manager.S1_NOTICE</code>.
     */
    public final S1NoticeTB S1_NOTICE = S1NoticeTB.S1_NOTICE;

    /**
     * The table <code>document_manager.S1_OPERATE</code>.
     */
    public final S1OperateTB S1_OPERATE = S1OperateTB.S1_OPERATE;

    /**
     * The table <code>document_manager.S1_USER</code>.
     */
    public final S1UserTB S1_USER = S1UserTB.S1_USER;

    /**
     * No further instances allowed
     */
    private DocumentManager() {
        super("document_manager", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            S1AttachTB.S1_ATTACH,
            S1BuTB.S1_BU,
            S1CommentTB.S1_COMMENT,
            S1DirTB.S1_DIR,
            S1DocTB.S1_DOC,
            S1LogTB.S1_LOG,
            S1NodeTB.S1_NODE,
            S1NoticeTB.S1_NOTICE,
            S1OperateTB.S1_OPERATE,
            S1UserTB.S1_USER);
    }
}
