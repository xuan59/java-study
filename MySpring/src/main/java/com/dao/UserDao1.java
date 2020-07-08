package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addUser(String name ,Integer age){
        String sql="insert into users(name,age) values(?,?)";
        System.out.println("开始添加数据了。。。。");
        jdbcTemplate.update(sql,name,age);
        System.out.println("添加数据成功。。。。");
    }
}
