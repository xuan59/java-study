package com.concurrency.atomic;

import com.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicTest5 {

    private static AtomicIntegerFieldUpdater<AtomicTest5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicTest5.class,"count");

    @Getter
    public volatile int count = 100;

    private static AtomicTest5 atomicTest5 = new AtomicTest5();

    public static void main(String[] args) {

        if(updater.compareAndSet(atomicTest5,100,120)){
            System.out.println(atomicTest5.count);
        }
        if(updater.compareAndSet(atomicTest5,100,120)){
            System.out.println("---"+atomicTest5.count);
        }else{
            System.out.println("***"+atomicTest5.count);
        }

    }


}
