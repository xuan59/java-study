package com.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest5 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(()->{
            try{
                reentrantLock.lock();
                System.out.println("wait signal");
                condition.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("get signal");
            reentrantLock.unlock();
        }).start();
        new Thread(()->{
            reentrantLock.lock();
            System.out.println("get lock");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("send signal");
            reentrantLock.unlock();
        }).start();
    }
}
