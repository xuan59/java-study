package com.spring_factory.implement;

import com.spring_factory.bean.BeanFactory;
import com.spring_factory.dao.UserDao;
import com.spring_factory.service.UserService;

/*
* 业务层实现类
* */
public class UserServiceImpl implements UserService {

    //private UserDao userDao = new UserDaoImpl();
    private UserDao userDao;

    public void saveUser() {
        try {
            userDao = (UserDao) BeanFactory.getBean("userDao");
        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.saveUser();
    }
}
