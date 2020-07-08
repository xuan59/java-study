package com.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class springMQ_Consumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        springMQ_Consumer consumer = (springMQ_Consumer) applicationContext.getBean("springMQ_Consumer");
        String message = (String) consumer.jmsTemplate.receiveAndConvert();
        System.out.println("收到消息：" + message);
    }
}
