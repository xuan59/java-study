package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy  //比 EnableZuulService 更完善
@SpringBootApplication
public class SpringcloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulApplication.class, args);
    }

}
