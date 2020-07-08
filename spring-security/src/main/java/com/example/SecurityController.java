package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") Integer id){
        return "level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") Integer id){
        return "level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") Integer id){
        return "level3/"+id;
    }

}
