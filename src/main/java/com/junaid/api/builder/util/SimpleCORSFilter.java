package com.junaid.api.builder.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Configuration
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String clientOrigin = request.getHeader("origin");

        //TODO: Check for clientOrigin

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", clientOrigin);
        //response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "5");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type,Accept,Authorization");
        //response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Credentials", "false");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
        //DO NOTHING
    }

    public void destroy() {
        //DO NOTHING
    }
}
