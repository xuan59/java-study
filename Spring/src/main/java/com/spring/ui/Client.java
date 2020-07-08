package com.spring.ui;

import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/*
* 模拟表现层，用于调用业务层
* */
public class Client {
    /*
    * ApplicationContext的方法说明：
    *   ClassPathXmlApplicationContext       加载类路径下的配置文件，要求必须在类路径下
    *   FileSystemXmlApplicationContext      加载磁盘任意路径下的配置文件，要求必须对磁盘有访问权限
    *   AnnotationConfigApplicationContext   读取注解
    * */
    public static void main(String[] args) throws Exception {

        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        UserService userService = (UserService) applicationContext.getBean("userService2");
        //UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userService);
        //System.out.println(userDao);
        userService.saveUser();

    }
}
