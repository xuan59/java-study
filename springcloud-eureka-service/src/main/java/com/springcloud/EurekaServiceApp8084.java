package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启Eureka注册中心服务端
@SpringBootApplication
public class EurekaServiceApp8084 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApp8084.class, args);
    }

}
