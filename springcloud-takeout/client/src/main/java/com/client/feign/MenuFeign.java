package com.client.feign;

import com.client.bean.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("menu")
public interface MenuFeign {
    @GetMapping("/menu/")
    List<Menu> findAll();
}
