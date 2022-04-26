package cn.luoyanze.documentmanager.filter;

import cn.luoyanze.common.model.TokenResult;
import cn.luoyanze.common.util.TokenUtil;
import cn.luoyanze.common.contract.common.RequestHead;
import cn.luoyanze.documentmanager.service.wrapper.BodyCheckServletRequestWapper;
import com.alibaba.fastjson.JSON;
import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/2 10:52 PM
 */
@Component
@Order(1)
@WebFilter()
public class IdentifyFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(IdentifyFilter.class);
    private final static Set<String> EXCLUDE_URLS = Set.of("/api/login");

    private final MultipartResolver multipartResolver;

    public IdentifyFilter(MultipartResolver multipartResolver) {
        this.multipartResolver = multipartResolver;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException {

        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        try {
            if (EXCLUDE_URLS.contains(path) || CorsUtils.isPreFlightRequest(req)) {
                filterChain.doFilter(req, response);
                return;
            }

            RequestHead requestHead;
            if (multipartResolver.isMultipart(req)) {
                MultipartHttpServletRequest multipart = multipartResolver.resolveMultipart(req);
                requestHead =
                        JSON.parseObject(
                                new String(multipart.getPart("head").getInputStream().readAllBytes()),
                                RequestHead.class
                        );
                if (validate(requestHead)) {
                    filterChain.doFilter(multipart, response);
                } else {
                    resp.sendError(HttpStatus.FORBIDDEN.value(), "验证失败， 请重新登录");
                }
            } else {
                BodyCheckServletRequestWapper requestWrapper = new BodyCheckServletRequestWapper(req);
                String json = requestWrapper.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

                requestHead = Optional.ofNullable(JSON.parseObject(json, Map.class))
                                .map(it -> it.get("head"))
                                .map(it -> JSON.parseObject(it.toString(), RequestHead.class)).orElse(null);

                if (validate(requestHead)) {
                    filterChain.doFilter(requestWrapper, response);
                } else {
                    resp.sendError(HttpStatus.FORBIDDEN.value(), "验证失败， 请重新登录");
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private boolean validate(RequestHead head) {
        if (head == null) {
            return false;
        }

        if (!StringUtils.isEmpty(head.getToken())) {
            TokenResult res = TokenUtil.vaildToken(head.getToken(), head.getUsername());
            return TokenResult.checkValid(res);
        }

        return false;
    }
}
