package com.dubbo.service;

import com.dubbo.bean.UserAddress;

import java.util.List;

/*
*   用户服务
* */
public interface UserService {
    //根据用户Id返回收货地址
    public List<UserAddress> getUserAddressList(String userId);

}
