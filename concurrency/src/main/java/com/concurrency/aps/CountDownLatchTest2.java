package com.concurrency.aps;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest2 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for(int i=0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();//类似于一个计数器，值减到0就代表进程执行完了
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS); //保证之后的进程在等待10毫秒后就开始执行
        System.out.println("执行完毕.....");
        executorService.shutdown();

    }
    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1);
        System.out.println(threadNum);
    }

}
