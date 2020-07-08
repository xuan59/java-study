package com.concurrency.singleton;

import com.concurrency.annoations.NotThreadSafe;

/*
*   懒汉模式
*   单例实例在第一次使用时进行创建
* */
@NotThreadSafe
public class SingletonTest1 {

    //私有构造函数
    private SingletonTest1(){

    }
    //单例对象
    private static SingletonTest1 instance = null;
    //静态的工厂方法
    public static SingletonTest1 getInstance(){
        if (instance==null){
            instance = new SingletonTest1();
        }
        return instance;
    }
}
