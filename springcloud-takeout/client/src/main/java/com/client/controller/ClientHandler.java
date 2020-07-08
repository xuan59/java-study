package com.client.controller;

import com.client.bean.Menu;
import com.client.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientHandler {
    @Autowired
    private MenuFeign menuFeign;
    @GetMapping("/index")
    public String index(ModelMap map){
        List<Menu> menus = menuFeign.findAll();
        System.out.println(menus);
        map.addAttribute("menus",menus);
        return "MenuList";
    }

}
