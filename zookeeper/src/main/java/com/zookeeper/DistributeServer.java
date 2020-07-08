package com.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;


class ConnectZookeeper implements Watcher{
    private ZooKeeper zookeeper;

    // 超时时间
    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
            System.out.println("连接中......");
            countDownLatch.countDown();
            System.out.println("开始监听......");
            try {
                System.out.println(zookeeper.getChildren("/servers",true));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
        }
    }

    /**
     * 连接zookeeper
     */
    public ZooKeeper Connect(String host) throws Exception {
        zookeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        System.out.println("连接成功！！！！");
        return zookeeper;
    }


}


public class DistributeServer {
    private ZooKeeper zooKeeper;
    public static void main(String[] args) throws Exception {
        DistributeServer distributeServer = new DistributeServer();
        //连接zookeeper集群
        distributeServer.getConnect();
        //注册节点
        distributeServer.resgist(args[0]);
        //业务逻辑处理
        distributeServer.businness();

    }

    private void businness() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getConnect() throws Exception {
        ConnectZookeeper connectZookeeper = new ConnectZookeeper();
        zooKeeper = connectZookeeper.Connect("192.168.43.96:2181,192.168.43.116:2181,192.168.43.142:2181");
    }

    private void resgist(String hostName)throws Exception {
        String path = zooKeeper.create("/servers/server",hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName+"*****"+hostName);
    }


}
