package com.testspring;

        import com.service.UserService1;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService1 userService1 = (UserService1) applicationContext.getBean("userService1");
        userService1.add();
        System.out.println("执行完毕。。。");
    }
}
