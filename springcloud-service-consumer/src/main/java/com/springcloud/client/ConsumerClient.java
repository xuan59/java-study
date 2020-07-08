package com.springcloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("springcloud-service-provider")
public interface ConsumerClient {

    @GetMapping("/service/hello")
    String hello();

}
