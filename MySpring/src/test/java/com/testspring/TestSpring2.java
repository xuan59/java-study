package com.testspring;

import com.service.UserService;
import com.spring.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring2 {
    public static void main(String[] args) {
        //先加载spring容器
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring2.xml");
        //使用bean的id查找对象
        UserService userService = (UserService) application.getBean("userService");
        userService.add();
        System.out.println(userService.toString());

    }
}
