package com.aop.service;

/*
*  user的业务层接口
* */
public interface UserService {
    /*
    *  模拟方法
    * */
    void saveUser();
    void updateUser(int id);
     int deleteUser();

}
