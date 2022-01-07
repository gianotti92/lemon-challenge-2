package com.l2.challenge.filter;


import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {
    private static final String USER_ID_KEY = "user_id";

    @Value("${user.valid-user-id}")
    private String authenticatedUserId;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        Map<String, String> headers = new HashMap<>();

        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = httpRequest.getHeader(key);

            headers.put(key, value);
        }

        if(headers.isEmpty() || Strings.isBlank(headers.get(USER_ID_KEY))) {
            throw new RuntimeException("Invalid Headers");
        }

        String userIdRequested = headers.get(USER_ID_KEY);

        if(!authenticatedUserId.equals(userIdRequested)) {
            throw new RuntimeException("Invalid information");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
