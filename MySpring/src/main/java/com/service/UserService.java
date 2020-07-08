package com.service;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserService {
    @Resource
    private UserDao userDao;
    @Autowired
    private Aop aop;
    public void add(){
        aop.begin();
        System.out.println("逻辑层被调用了。。。");
        userDao.add();
        aop.begin();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
