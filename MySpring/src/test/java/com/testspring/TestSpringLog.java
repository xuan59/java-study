package com.testspring;

import com.service.UserService2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringLog {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService2 userService = (UserService2) applicationContext.getBean("userService2");
        userService.add();
        System.out.println("执行完毕。。。");

    }
}
