package com.cybersoft.springboot10.config;

import com.cybersoft.springboot10.service.TimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TimeService timeService(){
        return new TimeService();
    }
}
