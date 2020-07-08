package com.dubbo.impl;

import com.dubbo.bean.UserAddress;
import com.dubbo.service.OrderService;
import com.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    //@Autowired
    @Reference
    UserService userService;
    @Override
    public List<UserAddress> initOrder(String userId) {
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
        return userAddressList;
    }
}
