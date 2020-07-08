package com.spring_factory.ui;


import com.spring_factory.bean.BeanFactory;
import com.spring_factory.service.UserService;

/*
* 模拟表现层，用于调用业务层
* */
public class Client {
    private static UserService userService;
    public static void main(String[] args) throws Exception {
        //UserService userService = new UserServiceImpl();
        for(int i=0;i<5;i++) {
            userService = (UserService) BeanFactory.getBean("userService");
            System.out.println(userService);
        }
        userService.saveUser();

    }
}
