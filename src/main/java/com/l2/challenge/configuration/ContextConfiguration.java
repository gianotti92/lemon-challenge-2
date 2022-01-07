package com.l2.challenge.configuration;

import com.l2.challenge.model.UserRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ContextConfiguration {

    @Bean
    @SessionScope
    public UserRequest getUserConfig() {
        return  new UserRequest();
    }
}
