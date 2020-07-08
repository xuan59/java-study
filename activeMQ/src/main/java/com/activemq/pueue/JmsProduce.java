package com.activemq.pueue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    public static final String ACTIVEMQ_URL="failover:(tcp://192.168.43.96:6166,tcp://192.168.43.116:6166,tcp://192.168.43.142:6166)?randomize=false";
    //public static final String ACTIVEMQ_URL="tcp://192.168.43.96:61616";
    //public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "QUEUE01";

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
        Queue queue = session.createQueue(QUEUE_NAME);

        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);

        //设置持久化（PERSISTENT）或非持久化（NON_PERSISTENT）
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

        //6、通过使用messageProducer 生产3条消息发送到MQ的队列中
        for (int i = 0; i < 3; i++) {
            //创建消息
            TextMessage message = session.createTextMessage("JDBC msg--" + (i + 1));
            //message.setStringProperty("c01","vip"+i);
            messageProducer.send(message);  //发送消息
            /*MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","MapMessage"+i);
            messageProducer.send(mapMessage);*/
        }
        messageProducer.close();
        session.close();
        connection.close();
        ;
        System.out.println("消息发送成功！");

    }
}
