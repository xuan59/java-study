package com.concurrency.syncContainer;

import com.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class CollectionsMapTest3 {
    private static int clientNum = 5000; //模拟客户端数量
    private static int threadNum = 200; //线程数量

    private static Map<Integer,Integer> set = Collections.synchronizedMap(Maps.newHashMap());

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
        set.put(a,a);
    }
}
