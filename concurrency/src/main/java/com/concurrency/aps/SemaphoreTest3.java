package com.concurrency.aps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest3 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(20);//20代表允许的并发数
        for(int i=0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    if(semaphore.tryAcquire()){ //尝试获取一个许可，
                        test(threadNum);
                        semaphore.release(); //释放一个许可
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                }
            });
        }

        System.out.println("执行完毕.....");
        executorService.shutdown();

    }
    private static void test(int threadNum) throws InterruptedException {
        System.out.println(threadNum);
        Thread.sleep(1000);
    }

}
