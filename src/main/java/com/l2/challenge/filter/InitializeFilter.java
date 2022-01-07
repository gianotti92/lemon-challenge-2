package com.l2.challenge.filter;

import com.l2.challenge.model.UserRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class InitializeFilter implements Filter {

    private static final Integer EXCEEDED_REQUEST_NUMBER = 5;

    private final UserRequest userRequest;

    public InitializeFilter(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        userRequest.addRequest();

        if((isTimeExceeded())) {
            userRequest.resetRequest();
        }

        if (isRequestNumberExceeded()) {
            throw new RuntimeException("request exceeded");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Boolean isTimeExceeded() {
        return System.currentTimeMillis() - userRequest.getTimeStamp() >= 10000L;
    }

    private Boolean isRequestNumberExceeded() {
        System.out.println(String.format("number of req: %s", userRequest.getNumberOfRequest()));
        return userRequest.getNumberOfRequest() > EXCEEDED_REQUEST_NUMBER;
    }
}
