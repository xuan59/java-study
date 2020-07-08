package com.bootactivemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class Queue_Produce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    public void QueueMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"*****"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("消息发送成功！");
    }

    //每3秒发送一条消息
    @Scheduled(fixedDelay = 3000)
    public void QueueMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"*****scheduled:"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("每3秒发送消息成功！");
    }
}
