package com.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    public static final String ACTIVEMQ_URL = "tcp://192.168.43.96:61616";
    public static final String TOPIC_NAME = "TOPIC01";

    public static void main(String[] args) throws JMSException {
        //1、创建activeMQ工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //2、通过连接工厂，获取连接connection 并访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3、创建会话Session  第一个参数是事务，第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //4、创建目的地（具体是队列（queue）还是主题（topic））
        //Destination destination = session.createQueue(QUEUE_NAME);  //Destination 表示创建的是目的地
        Topic topic = session.createTopic(TOPIC_NAME);

        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);

        //6、通过使用messageProducer 生产3条消息发送到MQ的队列中
        for (int i = 0; i < 6; i++) {
            //创建消息
            TextMessage message = session.createTextMessage("msg--" + (i + 1));
            messageProducer.send(message);  //发送消息
        }
        messageProducer.close();
        session.close();
        connection.close();
        ;
        System.out.println("消息发送成功！");

    }
}
