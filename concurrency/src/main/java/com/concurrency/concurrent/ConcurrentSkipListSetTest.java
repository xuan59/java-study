package com.concurrency.concurrent;

import com.concurrency.annoations.ThreadSafe;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@ThreadSafe
public class ConcurrentSkipListSetTest {
    private static int clientNum = 5000; //模拟客户端数量
    private static int threadNum = 200; //线程数量

    private static Set<Integer> set = new ConcurrentSkipListSet<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadNum);
        final CountDownLatch countDownLatch = new CountDownLatch(clientNum);
        for (int i = 0; i < clientNum; i++) {
            final int a = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(a);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(set.size());
    }
    public static void add(int a){
        set.add(a);
    }
}
