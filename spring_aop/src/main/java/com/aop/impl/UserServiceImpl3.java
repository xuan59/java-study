package com.aop.impl;

import com.aop.service.UserService;
import org.springframework.stereotype.Service;

/*
 *  user 的业务层实现类
 * */
@Service("userService")
public class UserServiceImpl3 implements UserService {

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
