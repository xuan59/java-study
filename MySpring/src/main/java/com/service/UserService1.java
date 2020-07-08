package com.service;

import com.Transaction.TransactionManager;
import com.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

@Service
public class UserService1 {
    @Autowired
    private TransactionManager transactionManager;
    @Autowired
    private UserDao1 userDao;
    public void add(){
       /* TransactionStatus transactionStatus=null;
        try {
            transactionStatus = transactionManager.begin();
            System.out.println("addUser方法被调用了。。");
            userDao.addUser("宝宝",22);
            //int i = 1/0;
            userDao.addUser("乖乖",23);
            transactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            //发生异常进行回滚
            if(transactionStatus!=null) {
                transactionManager.rollback(transactionStatus);
            }
        }
        */
        System.out.println("addUser方法被调用了。。");
        userDao.addUser("宝宝来了",22);
        //int i = 1/0;
        userDao.addUser("乖乖来了",23);
    }
}
