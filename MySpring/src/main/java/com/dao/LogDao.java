package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addLog(){
        String sql="insert into log values(null,?)";
        jdbcTemplate.update(sql,System.currentTimeMillis());
        System.out.println("添加日志数据成功。。。。");
    }
}
