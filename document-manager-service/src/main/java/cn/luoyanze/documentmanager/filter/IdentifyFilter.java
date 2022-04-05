package cn.luoyanze.documentmanager.filter;

import cn.luoyanze.common.model.TokenResult;
import cn.luoyanze.common.util.TokenUtil;
import cn.luoyanze.common.contract.entity.RequsetHead;
import cn.luoyanze.documentmanager.service.wrapper.BodyCheckServletRequestWapper;
import com.alibaba.fastjson.JSON;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_USER;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 10:52 PM
 */
@Component
@Order(1)
public class IdentifyFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(IdentifyFilter.class);
    private final DSLContext dao;

    public IdentifyFilter(DSLContext dao) {
        this.dao = dao;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            BodyCheckServletRequestWapper requestWrapper = new BodyCheckServletRequestWapper((HttpServletRequest) request);
            String json = requestWrapper.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            RequsetHead head =
                    Optional.ofNullable(JSON.parseObject(json, Map.class))
                            .map(it -> it.get("head"))
                            .map(it -> JSON.parseObject(it.toString(), RequsetHead.class)).orElse(null);

            if (validate(head)) {
                filterChain.doFilter(requestWrapper, response);
            } else {
                resp.sendError(HttpStatus.FORBIDDEN.value(), "验证失败， 请重新登录");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private boolean validate(RequsetHead head) {
        if (head == null) {
            return false;
        }

        if (!StringUtils.isEmpty(head.getToken())) {
            TokenResult res = TokenUtil.vaildToken(head.getToken(), head.getUsername());
            return TokenResult.checkValid(res);
        } else {

            Record2<String, String> record = dao.select(S1_USER.ACCOUNT, S1_USER.PASSWORD)
                    .from(S1_USER)
                    .where(S1_USER.ACCOUNT.eq(head.getUsername()))
                    .limit(1)
                    .fetchOne();

            String password =
                    Optional.ofNullable(record).map(it -> it.getValue(S1_USER.PASSWORD)).orElse("");

            return password.equals(head.getPassword());
        }
    }
}
