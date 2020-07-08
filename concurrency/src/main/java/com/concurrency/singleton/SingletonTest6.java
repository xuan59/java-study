package com.concurrency.singleton;

import com.concurrency.annoations.ThreadSafe;

/*
*   饿汉模式
*   单例实例在类装载时进行创建
* */
@ThreadSafe
public class SingletonTest6 {


    //私有构造函数
    private SingletonTest6(){

    }

    //单例对象
    private static SingletonTest6 instance = null;
    static {
        instance = new SingletonTest6();
    }
    //静态的工厂方法
    public static SingletonTest6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
