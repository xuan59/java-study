package com.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@ComponentScan("com.dubbo.service")
@SpringBootApplication
public class DubboBootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboBootConsumerApplication.class, args);
    }

}
