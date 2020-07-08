package com.concurrency.singleton;

import com.concurrency.annoations.Recommend;
import com.concurrency.annoations.ThreadSafe;

/*
*   使用枚举模式
* */
@ThreadSafe
@Recommend
public class SingletonTest7 {


    //私有构造函数
    private SingletonTest7(){

    }


    //静态的工厂方法
    public static SingletonTest7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonTest7 singletonTest7;
        //JVM保证这个方法绝对值调用一次
        Singleton(){
            singletonTest7 = new SingletonTest7();
        }
        public SingletonTest7 getInstance(){
            return singletonTest7;
        }
    }

}
