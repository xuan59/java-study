package com.boot_mqtopicproduce.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
@EnableJms
public class ConfigBean {
    @Value("${mytopic}")
    private String TopicName;
    @Bean
    public Topic topicMsg(){
        return new ActiveMQTopic(TopicName);
    }
}
