package com.concurrency.threadPool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest4 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        /*executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule run");
            }
        },3, TimeUnit.SECONDS);*/

        //间隔3秒执行一次
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule run");
            }
        },1,3,TimeUnit.SECONDS);
        //executorService.shutdown();
        //间隔5秒执行一次
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer run");
            }
        },new Date(),5*1000);
    }
}
