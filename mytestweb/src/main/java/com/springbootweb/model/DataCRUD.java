package com.springbootweb.model;

import com.springbootweb.bean.Users;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataCRUD {
    private JdbcTemplate jdbcTemplate;
    public Users selectSQLAll(){
        Users users = new Users();

        return users;
    }
}
