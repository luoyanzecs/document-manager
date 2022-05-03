package cn.luoyanze.documentmanager.filter;

import cn.luoyanze.common.context.TraceContext;
import cn.luoyanze.common.contract.common.RequestHead;
import cn.luoyanze.common.util.TimeUtil;
import cn.luoyanze.documentmanager.dao.tables.records.S1TraceRecord;
import cn.luoyanze.documentmanager.service.wrapper.BodyCheckServletRequestWapper;
import com.alibaba.fastjson.JSON;
import org.jooq.DSLContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static cn.luoyanze.documentmanager.dao.Tables.S1_TRACE;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 2:27 AM
 */

@Component
@Order(2)
@WebFilter
public class RequstStoreFilter implements Filter {

    private final MultipartResolver multipartResolver;
    private final DSLContext dao;

    public RequstStoreFilter(MultipartResolver multipartResolver, DSLContext dao) {
        this.multipartResolver = multipartResolver;
        this.dao = dao;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        if ("/api/checkHealth".equalsIgnoreCase(path)) {

            //if (multipartResolver.isMultipart(req)) {
            //    MultipartHttpServletRequest multipart = multipartResolver.resolveMultipart(req);
            //    RequestHead  head =
            //            JSON.parseObject(
            //                    new String(multipart.getPart("head").getInputStream().readAllBytes()),
            //                    RequestHead.class
            //            );
            //    multipart.getParts().stream().collect(Collectors.groupingBy())
            //} else

            if (req.getMethod().equalsIgnoreCase("POST")) {
                BodyCheckServletRequestWapper requestWrapper = new BodyCheckServletRequestWapper(req);
                String json = requestWrapper.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                RequestHead head = Optional.ofNullable(JSON.parseObject(json, Map.class))
                        .map(it -> it.get("head"))
                        .map(it -> JSON.parseObject(it.toString(), RequestHead.class)).orElse(null);

                TraceContext.setRequest(
                        json,
                        Optional.ofNullable(head).map(RequestHead::getUserId).orElse(null) + "",
                        (id, ctx, userId) -> {
                            S1TraceRecord record = new S1TraceRecord();
                            record.setUuid(id);
                            record.setUserId(Integer.parseInt(id));
                            record.setUrl(Optional.of(path).orElse(""));
                            record.setStoreRequest(ctx);
                            record.setRequestTime(TimeUtil.now());
                            record.insert();
                        }
                );

                chain.doFilter(requestWrapper, resp);
            }

        } else {
            chain.doFilter(req, resp);
        }
    }
}



