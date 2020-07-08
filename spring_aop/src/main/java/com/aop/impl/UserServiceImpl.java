package com.aop.impl;

import com.aop.service.UserService;

/*
*  user 的业务层实现类
* */
public class UserServiceImpl implements UserService {

    public void saveUser() {
        System.out.println("保存");
    }

    public void updateUser(int id) {
        System.out.println("更新");
    }

    public int deleteUser() {
        System.out.println("删除");
        return 0;
    }
}
