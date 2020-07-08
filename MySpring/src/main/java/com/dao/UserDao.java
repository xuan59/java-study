package com.dao;

public class UserDao {
    private String flag;
    public void add(){
        System.out.println("数据层被调用了。。。");
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
