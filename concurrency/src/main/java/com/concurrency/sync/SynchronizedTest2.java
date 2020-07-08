package com.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest2 {

    public static void test1(int a){
        synchronized (SynchronizedTest.class){
            for (int i=0;i<10;i++){
                System.out.println("test1 "+a+"  "+i);
            }
        }
    }

    public static synchronized void test2(int a ){
        for (int i=0;i<10;i++){
            System.out.println("test2 "+a+"   "+i);
        }
    }

    public static void main(String[] args) {
        SynchronizedTest2 synchronizedTest1 = new SynchronizedTest2();
        SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizedTest1.test1(1);
        });
        executorService.execute(()->{
            synchronizedTest2.test1(2);
        });
    }
}
