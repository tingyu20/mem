package com.cumt.mem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableTransactionManagement   //开启事务管理
public class MemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MemApplication.class, args);
    }

}

