package cn.luoyanze.documentmanager.log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.helpers.Transform;
import cn.luoyanze.documentmanager.dao.tables.records.S1LogRecord;
import org.jooq.DSLContext;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static cn.luoyanze.documentmanager.dao.Tables.S1_LOG;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/29 2:02 PM
 */


@Component
public class DBErrorLogAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    private final DSLContext dao;


    public DBErrorLogAppender(DSLContext dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void init() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        ThresholdFilter filter = new ThresholdFilter();
        filter.setLevel("ERROR");
        filter.setContext(context);
        filter.start();
        this.addFilter(filter);
        this.setContext(context);

        context.getLogger("ROOT").addAppender(DBErrorLogAppender.this);

        super.start();
    }

    /**
     * 错误日志拼装成实体类，写入数据库
     */
    @Override
    protected void append(ILoggingEvent loggingEvent) {
        IThrowableProxy tp = loggingEvent.getThrowableProxy();

        // ErrorLogPO数据表实体类
        S1LogRecord errorLog = new S1LogRecord();
        errorLog.setErrmsg(loggingEvent.getMessage());
        errorLog.setCreatetime(
                LocalDateTime.ofEpochSecond(
                        loggingEvent.getTimeStamp() / 1000,
                        (int) loggingEvent.getTimeStamp() % 1000,
                        ZoneOffset.of("+8"))
        );

        if (loggingEvent.getCallerData() != null && loggingEvent.getCallerData().length > 0) {
            StackTraceElement element = loggingEvent.getCallerData()[0];
            errorLog.setClassname(element.getClassName());
            errorLog.setMethodname(element.getMethodName());
        }

        if (tp != null) {
            errorLog.setExceptionname(tp.getClassName());
            errorLog.setStacktrace(getStackTraceMsg(tp));
        }

        try {
            // 错误日志实体类写入数据库
            dao.insertInto(S1_LOG).set(errorLog).execute();
        } catch (Exception ex) {
            this.addError("上报错误日志失败：" + ex.getMessage());
        }
    }


    private String getStackTraceMsg(IThrowableProxy tp) {
        StringBuilder buf = new StringBuilder();

        if (tp != null) {
            while (tp != null) {
                this.renderStackTrace(buf, tp);
                tp = tp.getCause();
            }
        }

        return buf.toString();
    }

    private void renderStackTrace(StringBuilder sbuf, IThrowableProxy tp) {
        this.printFirstLine(sbuf, tp);
        int commonFrames = tp.getCommonFrames();
        StackTraceElementProxy[] stepArray = tp.getStackTraceElementProxyArray();

        for (int i = 0; i < stepArray.length - commonFrames; ++i) {
            StackTraceElementProxy step = stepArray[i];
            sbuf.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
            sbuf.append(Transform.escapeTags(step.toString()));
            sbuf.append(CoreConstants.LINE_SEPARATOR);
        }

        if (commonFrames > 0) {
            sbuf.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
            sbuf.append("\t... ").append(commonFrames).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
        }

    }

    /**
     * 拼装堆栈跟踪信息第一行
     */
    public void printFirstLine(StringBuilder sb, IThrowableProxy tp) {
        int commonFrames = tp.getCommonFrames();
        if (commonFrames > 0) {
            sb.append("<br />").append("Caused by: ");
        }

        sb.append(tp.getClassName()).append(": ").append(Transform.escapeTags(tp.getMessage()));
        sb.append(CoreConstants.LINE_SEPARATOR);
    }
}


