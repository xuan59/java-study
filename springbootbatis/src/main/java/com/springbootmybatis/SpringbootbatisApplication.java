package com.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(" com.springbootmybatis.mapper")
@SpringBootApplication
public class SpringbootbatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbatisApplication.class, args);
    }

}
