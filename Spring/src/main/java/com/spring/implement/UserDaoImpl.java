package com.spring.implement;

import com.spring.dao.UserDao;

/*
* 持久层实现类
* */
public class UserDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("持久层保存了user");
    }
}
