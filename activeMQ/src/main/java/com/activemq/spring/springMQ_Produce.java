package com.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class springMQ_Produce {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        springMQ_Produce produce = (springMQ_Produce) context.getBean("springMQ_Produce");
       /* produce.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("spring和activeMQ整合case..");
                return textMessage;
            }
        });*/
        produce.jmsTemplate.send((Session session) -> {
            TextMessage textMessage = session.createTextMessage("spring和activeMQ整合监听消息..");
            return textMessage;
        });

        System.out.println("消息发送成功！");
    }

}
