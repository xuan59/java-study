package com.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
//配置redis连接池
public class redisUtls {
    private static JedisPool pool;
    static{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(5);//最大连接数
        jedisPoolConfig.setMaxIdle(1);//最大空闲数
        pool = new JedisPool(jedisPoolConfig,"192.168.43.96",6379);
    }
    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        jedis.auth("123456");
        return jedis;
    }
    public static void close(Jedis jedis){
        jedis.close();
    }
}
