package com.spring.implement;

import com.spring.bean.BeanFactory;
import com.spring.dao.UserDao;
import com.spring.service.UserService;

import java.util.Date;

/*
* 业务层实现类
* */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private String name;
    private String age;
    private Integer old;
    private Date birthday;

/*    public UserServiceImpl(String name, String age, Integer old, Date birthday) {
        this.name = name;
        this.age = age;
        this.old = old;
        this.birthday = birthday;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveUser() {

        System.out.println(name+"  "+age+"  "+old+"  "+birthday);
    }
}
