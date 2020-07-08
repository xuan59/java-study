package com.concurrency.aps;

import java.util.concurrent.*;

public class CyclicBarrierTest3 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        System.out.println("线程到达则个屏障的时候执行");
    });
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println(threadNum);

        cyclicBarrier.await();

        System.out.println("执行完毕...."+threadNum);
    }
}
