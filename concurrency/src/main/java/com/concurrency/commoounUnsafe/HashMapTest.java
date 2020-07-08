package com.concurrency.commoounUnsafe;

import com.concurrency.annoations.NotThreadSafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class HashMapTest {
    private static int clientNum = 5000; //模拟客户端数量
    private static int threadNum = 200; //线程数量

    private static Map<Integer,Integer> map = new HashMap<>();

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
        System.out.println(map.size());
    }
    public static void add(int a){
        map.put(a,a);
    }
}
