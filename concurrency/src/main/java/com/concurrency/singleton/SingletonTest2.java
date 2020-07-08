package com.concurrency.singleton;

import com.concurrency.annoations.ThreadSafe;

/*
*   饿汉模式
*   单例实例在类装载时进行创建
* */
@ThreadSafe
public class SingletonTest2 {

    //私有构造函数
    private SingletonTest2(){

    }
    //单例对象
    private static SingletonTest2 instance = new SingletonTest2();
    //静态的工厂方法
    public static SingletonTest2 getInstance(){
        return instance;
    }
}
