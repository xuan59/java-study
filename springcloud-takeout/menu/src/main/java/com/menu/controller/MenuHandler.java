package com.menu.controller;

import com.menu.bean.Menu;
import com.menu.mapper.MenuMapper;
import com.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuRepository menuRepository;
    @GetMapping("/")
    public List<Menu> findAll(String name){
        System.out.println(menuRepository.findMenuAll("肉"));
        System.out.println(name);
        return menuRepository.findMenuAll("");
    }
}
