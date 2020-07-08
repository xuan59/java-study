package com.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("宝贝", "乖乖", "小可爱"));
        return "test";
    }
}
