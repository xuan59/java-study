package com.service;

import com.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {
    @Autowired
    private LogDao logDao;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLog(){
        logDao.addLog();
        System.out.println("插入日志成功。。。");
    }
}
