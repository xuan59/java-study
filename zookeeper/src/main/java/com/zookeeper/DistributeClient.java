package com.zookeeper;

import org.apache.zookeeper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class ClientConnectZookeeper implements Watcher {
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
                System.out.println(zookeeper.getChildren("/servers", true));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }/*try {
                DistributeClient distributeClient = new DistributeClient();
                distributeClient.getChildren();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
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


public class DistributeClient {
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws Exception {
        DistributeClient distributeClient = new DistributeClient();
        //连接zookeeper集群
        distributeClient.getConnect();
        //注册监听
        distributeClient.getChildren();
        //业务逻辑处理
        distributeClient.businness();

    }

    private void businness() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getConnect() throws Exception {
        ClientConnectZookeeper connectZookeeper = new ClientConnectZookeeper();
        zooKeeper = connectZookeeper.Connect("192.168.43.96:2181,192.168.43.116:2181,192.168.43.142:2181");
    }

    public void getChildren() throws Exception {
        List<String> children = zooKeeper.getChildren("/servers", true);
        //System.out.println("监听：" + children);
        ArrayList<String> hosts = new ArrayList<String>();
        for (String chil:children){
            byte[] data = zooKeeper.getData("/servers/" + chil, false, null);
            hosts.add(data.toString());
        }
        System.out.println("服务器主机集合："+hosts);
    }


}
