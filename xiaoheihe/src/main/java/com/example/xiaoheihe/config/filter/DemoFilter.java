package com.example.xiaoheihe.config.filter;

import com.example.xiaoheihe.domain.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/demo",filterName = "DemoFilter")
public class DemoFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(DemoFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入自定义filter");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("自定义filter结束");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
