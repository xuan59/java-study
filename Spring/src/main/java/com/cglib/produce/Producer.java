package com.cglib.produce;

/*
*  生产者
* */
public class Producer{
    /*
    *  销售
    * */
    public void saleProduct(float money){
        System.out.println("销售成功，收到"+money+"元");
    }
    /*
    * 售后
    * */
    public void afterService(float money){
        System.out.println("售后服务，拿到"+money+"元");
    }

}
