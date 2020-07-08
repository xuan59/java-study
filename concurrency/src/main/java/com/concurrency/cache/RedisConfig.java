package com.concurrency.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfig {
    @Bean("redisPool")
    public JedisPool jedisPool(@Value("${spring.redis.host}")String host,@Value("${spring.redis.port}") int port){
        return new JedisPool(host,port);
    }
}
