package com.dubbo.impl;


import com.dubbo.bean.UserAddress;
import com.dubbo.mapper.UserAddressMapper;
import com.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service //dubbo下的注解，表示暴露服务
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserAddressMapper userAddressMapper;
    public List<UserAddress> getUserAddressList(String userId) {

        /*
        *   静态数据
        * */
        //UserAddress userAddress1 = new UserAddress(1,"重庆合川合阳街道","1","张三","123456","Y");
        //UserAddress userAddress2 = new UserAddress(2,"重庆合川合阳街道","1","张三","123456","Y");
        return userAddressMapper.getUserAddress(userId);
    }
}
