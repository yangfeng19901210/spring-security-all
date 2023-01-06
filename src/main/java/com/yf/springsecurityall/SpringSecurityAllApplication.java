package com.yf.springsecurityall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yf.springsecurityall.mapper")
public class SpringSecurityAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAllApplication.class, args);
    }

}
