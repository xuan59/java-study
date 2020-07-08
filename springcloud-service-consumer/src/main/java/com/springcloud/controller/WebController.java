package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.client.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@DefaultProperties(defaultFallback = "defaultError")
public class WebController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private ConsumerClient consumerClient;

//    @HystrixCommand(fallbackMethod = "helloError")
//    @HystrixCommand(commandProperties = {
//            //@HystrixProperty(name="execution.isolation.thread.timeoutInMillisecounds",value="3000")
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
    @GetMapping("/")
    public String hello() {
        /*if((int)Math.random()*10 % 2 ==0){
            throw new RuntimeException(); //设置异常，熔断当前请求
        }*/
        //根据服务名称获取实例
        List<ServiceInstance> instanceList = discoveryClient.getInstances("springcloud-service-provider");
        //从实例中获取IP和端口
        ServiceInstance instance = instanceList.get(0);
        System.out.println("从实例中获取的URL: "+instance.getHost()+":"+instance.getPort());
        //return restTemplate.getForEntity("http://localhost:8080/service/hello", String.class).getBody();
        //通过服务名称访问
//        return restTemplate.getForEntity("http://springcloud-service-provider/service/hello", String.class).getBody();
        return consumerClient.hello();
    }
    //该方法为请求失败后调用的方法，该方法应和上面的方法保持一致，即参数和返回值类中一致
    public String helloError(){
        return "服务器正忙，请稍后再试！";
    }
    public  String defaultError(){
        return "服务器正忙，请稍后再试！";
    }
}
