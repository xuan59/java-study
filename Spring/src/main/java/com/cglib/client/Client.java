package com.cglib.client;

import com.cglib.produce.Produce;
import com.cglib.produce.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /*
        *  动态代理：
        *       特点：字节码随用随创建，随用随加载
        *       作用：不修改源码的基础上对方法增强
        *       分类：
        *           基于接口的动态代理，基于子类的动态代理
        *       基于子类的动态代理：涉及的类：Enhancer，提供者：cglib jar包
        *       如何创建代理对象：使用Enhancer类中的create方法
        *       创建代理对象的要求：被代理类不能时最终类
        *       Enhance方法参数：
        *           class  字节码 ，用于指定被代理对象的字节码
        *           callback 用于增强代码，
        *           callback  提供增强的代码，让我们写如何代理，我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的
        * */

        Produce cglibProduce = (Produce) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //增强代码
                Object object = null;
                //1、获得方法执行的参数
                Float money = (Float)args[0];
                //2、判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){  //method当前执行的方法
                    object = method.invoke(producer,money*0.8f);
                }
                return object;
            }
        });

        cglibProduce.saleProduct(5000);

    }
}
