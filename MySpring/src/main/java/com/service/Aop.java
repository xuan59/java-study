package com.service;

import org.springframework.stereotype.Component;

@Component
public class Aop {

    public void begin(){
        System.out.println("事物开启");
    }
    public void commit(){
        System.out.println("事物提交");
    }
}
