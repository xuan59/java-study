package com.activemq.pueue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Jmsconsumer {
    public static final String ACTIVEMQ_URL="failover:(tcp://192.168.43.96:6166,tcp://192.168.43.116:6166,tcp://192.168.43.142:6166)?randomize=false";
    //public static final String ACTIVEMQ_URL="tcp://192.168.43.96:61616";
    //public static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "QUEUE01";

    public static void main(String[] args) throws JMSException, IOException, InterruptedException {
        System.out.println("我是2号消费者");
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

        //5、创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        //第一种同步阻塞接收消息方法
       /* while(true){
            TextMessage message = (TextMessage) consumer.receive(5000); //没有参数代表不停的等待，有参数代表等待时间

            if(message!=null){
                System.out.println("消费者收到了消息："+message);
            }else{
                break;
            }
        }*/

        //第二种接收消息方法，通过异步非阻塞监听器方式来接收
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage) {  //message instanceof TextMessage 判断 message 是否是 TextMessage类型的消息
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("消费者收到了消息：" + textMessage.getText());
                        //System.out.println("消费者收到消息的类型："+textMessage.getStringProperty("c01"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
               /* if(message!=null && message instanceof MapMessage){  //message instanceof TextMessage 判断 message 是否是 TextMessage类型的消息
                    MapMessage mapMessage = (MapMessage) message;
                    try {
                        System.out.println("消费者收到了消息："+mapMessage.getString("k1"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        });
        System.in.read();  //保持控制台处于运行状态

        //Thread.sleep(2000); //延迟2秒后关闭
        consumer.close();
        session.close();
        connection.close();
        System.out.println("消息阅读完毕！");
    }
}
