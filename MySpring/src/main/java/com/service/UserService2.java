package com.service;

import com.dao.LogDao;
import com.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserService2 {
    @Autowired
    private UserDao1 userDao;
    @Autowired
    private LogService logService;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(){
        logService.addLog();
        userDao.addUser("乖乖来了",23);
        int i = 1/0;
    }
}
