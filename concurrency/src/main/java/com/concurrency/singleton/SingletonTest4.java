package com.concurrency.singleton;



/*
*   懒汉模式  ---> 双重同步锁单例模式
*   单例实例在第一次使用时进行创建
* */

import com.concurrency.annoations.NotThreadSafe;

@NotThreadSafe
public class SingletonTest4 {

    //私有构造函数
    private SingletonTest4(){

    }

    /*
    *   为什么不安全？
    *    原因：JVM和CPU优化，发生了指令重排
    *    执行顺序：
    *        1、memory = allocate（） 分配对象的内存空间
    *        2、new SingletonTest4() 初始化对象
    *        3、instance = memory 设置instance指向刚分配的内存
    *    指令重排后的顺序：
    *        1、memory = allocate（） 分配对象的内存空间
    *        3、instance = memory 设置instance指向刚分配的内存
    *        2、new SingletonTest4() 初始化对象
    *
    * */

    //单例对象
    private static SingletonTest4 instance = null;

    //静态的工厂方法
    public static synchronized SingletonTest4 getInstance(){
        if (instance == null){
            synchronized (SingletonTest4.class){
                if(instance == null) {
                    instance = new SingletonTest4();
                }
            }

        }
        return instance;
    }
}
