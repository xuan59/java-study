package com.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    public void test1(int a){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println("test1 "+a+"  "+i);
            }
        }
    }

    public synchronized void test2(int a ){
        for (int i=0;i<10;i++){
            System.out.println("test2 "+a+"   "+i);
        }
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            synchronizedTest1.test1(1);
        });
        executorService.execute(()->{
            synchronizedTest2.test1(2);
        });
    }
}
