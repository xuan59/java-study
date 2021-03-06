package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //开启Eureka注册中心服务端
@SpringBootApplication
public class EurekaServiceApp8083 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApp8083.class, args);
    }

}
