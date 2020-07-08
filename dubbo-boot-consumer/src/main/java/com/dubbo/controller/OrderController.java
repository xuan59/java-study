package com.dubbo.controller;

import com.dubbo.bean.UserAddress;
import com.dubbo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/order")
    @ResponseBody
    public List<UserAddress> order(@RequestParam("userId") String userId){
        return orderService.initOrder(userId);
    }

}
