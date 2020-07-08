package com.bootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableJms
public class ConfigBean {
    @Value("${myqueue}")
    private String QueueName;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(QueueName);
    }

}
