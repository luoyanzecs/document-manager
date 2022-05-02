package cn.luoyanze.documentmanager.filter;

import cn.luoyanze.common.context.TraceContext;
import cn.luoyanze.documentmanager.service.wrapper.BodyCheckServletRequestWapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/5/3 2:27 AM
 */

@Component
@Order(2)
@WebFilter
public class RequstStoreFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        if ("/api/checkHealth".equalsIgnoreCase(path)) {
            BodyCheckServletRequestWapper requestWrapper = new BodyCheckServletRequestWapper(req);

            String json = requestWrapper.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            TraceContext.setRequest(json);

            chain.doFilter(requestWrapper, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }
}



