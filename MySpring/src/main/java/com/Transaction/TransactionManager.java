package com.Transaction;

import com.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Component
public class TransactionManager {
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    //事务开启
    public TransactionStatus begin(){
        //获取事务状态
        return dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
    }
    //事务提交
    public void commit(TransactionStatus transactionStatus){
        //把数据提交到数据库
       dataSourceTransactionManager.commit(transactionStatus);

    }
    //回滚(就是当数据发生异常，数据库要回滚)
    public void rollback(TransactionStatus transactionStatus){
        dataSourceTransactionManager.rollback(transactionStatus);
    }
    //事务关闭
}
