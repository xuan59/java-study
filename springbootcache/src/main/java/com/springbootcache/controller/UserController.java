package com.springbootcache.controller;

import com.springbootcache.bean.Users;
import com.springbootcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        Users user = userService.getUser(id);
        return user;
    }

    @GetMapping("/user")
    public Users updateUser(Users user){
        Users u = userService.updateUser(user);
        return u;
    }

    @GetMapping("/delete")
    public String deleteUser(Integer id){
        userService.deleteDelete(id);
        return "删除成功！！！";
    }

}
