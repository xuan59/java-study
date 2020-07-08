package com.boot_mqtopicproduce.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
public class Topic_Produce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
    @Scheduled(fixedDelay = 3000)
    public void topicProduce(){
        jmsMessagingTemplate.convertAndSend(topic,"***主题消息："+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("topic每3秒发送消息成功！");
    }

}
