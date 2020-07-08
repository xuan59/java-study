package com.concurrency.atomic;

import com.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class AtomicTest4 {

    private static AtomicReference count =new AtomicReference(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);  //当值为0时，更新为2
        count.compareAndSet(0,1);  //false
        count.compareAndSet(1,3);  //false
        count.compareAndSet(2,4);  //true
        count.compareAndSet(3,5);  //false
        System.out.println(count.get());
    }


}
