package com.springcloud;

import com.springcloud.config.MyRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


@RibbonClient(name = "SPRINGCLOUD-SERVICE-PROVIDER", configuration = MyRibbonConfig.class) //启用ribbon并对SPRINGCLOUD-SERVICE-PROVIDER进行负载平衡
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudServiceConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConsumerRibbonApplication.class, args);
    }

}
