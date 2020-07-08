package com.springboot.springboot;

import com.springboot.springboot.com.springboot.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

//@ImportResource(locations = {"classpath:beans.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;

//    @Test
//    public void testHelloService(){
//        boolean helloService = ioc.containsBean("helloService");
//        //System.out.println(helloService);
//    }

    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
        System.out.println(person);
        //日志的级别
        //由低到高  trace<debug<info<warn<error
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
        System.out.println("日志打印完毕");
    }

}
