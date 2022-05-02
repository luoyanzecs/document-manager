package cn.luoyanze.documentmanager.ignite;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static cn.luoyanze.documentmanager.dao.Tables.S1_BU;

/**
 * @author
 * @date 2022/5/2 15:52
 */
@Component
public class Ignite implements CommandLineRunner {
    private final DSLContext dao;
    private static final Logger LOGGER = LoggerFactory.getLogger(Ignite.class);
    public Ignite(DSLContext dao) {
        this.dao = dao;
    }

    public void run(String... args) {
        try{
            dao.select().from(S1_BU).execute();
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
