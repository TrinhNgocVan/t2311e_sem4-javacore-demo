package org.aptech.t2311e;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching// entry run service
public class SpringBootApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }
}