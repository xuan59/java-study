package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/web/hello")
    public String hello() {
        //return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        //通过服务名称访问
        return restTemplate.getForEntity("http://springcloud-service-provider/service/hello", String.class).getBody();

    }
    @GetMapping("/test")
    public String test(){
        ServiceInstance choose = loadBalancerClient.choose("springcloud-service-provider");
        System.out.println("1111111111"+choose.getServiceId()+"   "+choose.getHost()+":"+choose.getPort());
        return "";
    }
}
