package com.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Controller
public class jdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/query")
    public String map(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from users");
        for (Map<String,Object> map:list) {
            System.out.println(map);
        }
        return "查询成功";
    }
}
