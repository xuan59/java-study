package com.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer_Persistence {
    public static final String ACTIVEMQ_URL = "tcp://192.168.43.96:61616";
    public static final String TOPIC_NAME = "TOPIC01";

    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        System.out.println("我是1号消费者 zs");
        //1、创建activeMQ工厂，按照给定的url地址，采用默认的用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //2、通过连接工厂，获取连接connection 并访问
        Connection connection = activeMQConnectionFactory.createConnection();

        connection.setClientID("zs");

        //3、创建会话Session  第一个参数是事务，第二个参数是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //4、创建目的地（具体是队列（queue）还是主题（topic））
        //Destination destination = session.createQueue(QUEUE_NAME);  //Destination 表示创建的是目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "zs");

        connection.start();

        Message message = topicSubscriber.receive();

        while (message != null) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("收到持久化topic消息：" + textMessage.getText());
            message = topicSubscriber.receive(5000);

        }

        session.close();
        connection.close();

        System.out.println("消息阅读完毕！");
    }
}
