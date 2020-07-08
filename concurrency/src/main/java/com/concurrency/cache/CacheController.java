package com.concurrency.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private RedisClient redisClient;

    @RequestMapping("/set")
    public String set(@RequestParam("k")String k,@RequestParam("v")String v) throws Exception {
        System.out.println(k+v);
        redisClient.set(k,v);
        return "success";
    }
    @RequestMapping("/get")
    public String get(@RequestParam("k")String k) throws Exception {
        return redisClient.get(k);

    }

}
