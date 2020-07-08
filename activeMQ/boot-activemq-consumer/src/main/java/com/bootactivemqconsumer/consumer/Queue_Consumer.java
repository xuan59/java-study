package com.bootactivemqconsumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Queue_Consumer {
    @JmsListener(destination = "${myqueue}")
    public void receiveMsg(TextMessage textMessage) throws JMSException {
        System.out.println("*****收到的消息："+textMessage.getText());
    }
}
