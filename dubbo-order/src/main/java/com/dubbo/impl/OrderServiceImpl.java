package com.dubbo.impl;

import com.dubbo.bean.UserAddress;
import com.dubbo.service.OrderService;
import com.dubbo.service.UserService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    UserService userService;
    @Override
    public void initOrder(String userId) {
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
    }
}
