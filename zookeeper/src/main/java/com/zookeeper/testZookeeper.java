package com.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class testZookeeper implements Watcher {
    private ZooKeeper zookeeper;

    // 超时时间
    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("连接中......");
            countDownLatch.countDown();
            System.out.println("开始监听......");
            try {
                System.out.println(zookeeper.getChildren("/",true));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 连接zookeeper
     *     * @param host
     *     * @throws Exception
     *    
     */
    public ZooKeeper connectZookeeper(String host) throws Exception {
        zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        System.out.println("连接成功！！！！");
        return zookeeper;
    }

    /**
     * 获取节点
     */

/*
    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(path, false);
        return children;
    }
*/

    /**
     *     * 创建节点
     *    
     */
    public String createNode(String path, String data) throws Exception {
        return this.zookeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }


}

class TestZK {
    public static void main(String[] args) throws Exception {
        testZookeeper zookeeper = new testZookeeper();
        ZooKeeper zkCli = zookeeper.connectZookeeper("192.168.43.96:2181,192.168.43.116:2181,192.168.43.142:2181");
        System.out.println("监听到的数据："+zkCli.getChildren("/", true));

        System.out.println(zkCli.exists("/lx",false)==null? "false":"true");

        Thread.sleep(10000000);
        //String s = zkCli.create("/xxxx", "小宝贝嘿嘿嘿".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zookeeper.createNode("/xxxxx","小宝贝嘻嘻嘻嘻");
//        System.out.println("创建节点成功！！");
//        System.out.println(zkCli.getChildren("/", false));
       /* List<String> children = zookeeper.getChildren("/");
        System.out.println(children);
        */
    }
}