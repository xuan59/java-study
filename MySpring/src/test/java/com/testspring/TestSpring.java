package com.testspring;

import com.spring.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //先加载spring容器
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
        //使用bean的id查找对象
        UserEntity userentity = (UserEntity) application.getBean("StaticUserEntity");
        System.out.println(userentity.toString());

    }
}
