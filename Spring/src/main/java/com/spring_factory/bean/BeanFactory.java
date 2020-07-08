package com.spring_factory.bean;

import java.io.InputStream;
import java.util.Properties;

/*
* 用来创建service和dao对象
* */
public class BeanFactory {
    private static Properties properties;
    static {

        try {
            properties = new Properties();
            //获取配置文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化配置文件失败");
        }
    }
    public static Object getBean(String beanName) throws Exception{
        Object bean = null;
        String path = properties.getProperty(beanName);
        bean = Class.forName(path).newInstance();
        return bean;
    }
}
