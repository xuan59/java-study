package com.boot_mqtopicconsumer.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Topic_Consumer {
    @JmsListener(destination = "${mytopic}")
    public void receiveMsg(TextMessage textMessage) throws JMSException {
        System.out.println("topic收到的消息："+textMessage.getText());
    }
}
