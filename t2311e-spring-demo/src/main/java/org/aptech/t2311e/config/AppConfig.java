package org.aptech.t2311e.config;

import org.aptech.t2311e.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// java base configs

@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public HelloController helloController(){
        return new HelloController();
    }
}
