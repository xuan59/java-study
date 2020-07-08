package com.concurrency.singleton;

import com.concurrency.annoations.NotRecommend;
import com.concurrency.annoations.ThreadSafe;

/*
*   懒汉模式
*   单例实例在第一次使用时进行创建
* */
@ThreadSafe
@NotRecommend
public class SingletonTest3 {

    //私有构造函数
    private SingletonTest3(){

    }
    //单例对象
    private static SingletonTest3 instance = null;
    //静态的工厂方法
    public static synchronized SingletonTest3 getInstance(){
        if (instance==null){
            instance = new SingletonTest3();
        }
        return instance;
    }
}
