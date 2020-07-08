package com.springbootcache;

import com.springbootcache.bean.Users;
import com.springbootcache.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcacheApplicationTests {
    @Autowired
    UserMapper userMapper;

    /*@Autowired
    StringRedisTemplate stringRedisTemplate;  //操作 k v字符串
    @Autowired
    RedisTemplate redisTemplate; //k v操作对象
    //自动化序列
    @Autowired
    RedisTemplate<Object,Users> usersRedisTemplate;*/

    /*
        * Redis 常见的五大数据类型
        *   String（字符串），List(列表)，List(列表)，Hash(散列)，ZSet(有序集合)
        * stringRedisTemplate.opsForValue() 字符串
          stringRedisTemplate.opsForList()  列表
          stringRedisTemplate.opsForSet()   集合
          stringRedisTemplate.opsForHash()  散列
          stringRedisTemplate.opsForZSet()  有序集合
        *
        * */
/*
    @Test
    public void test01(){
        stringRedisTemplate.opsForValue().append("msg", "Hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("muList","2");

    }

    @Test
    public void test02(){
        Users user = userMapper.getUser(3);
        //默认保存对象使用jdk序列化机制，序列化后的数据保存到redis中
        //需要序列化，不然会报错  在Users 中实现 Serializable public Users implements Serializable
        redisTemplate.opsForValue().set("user",user);
        //将数据以json的方式保存,通过自己来配置自动配置
        usersRedisTemplate.opsForValue().set("user",user);

    }
*/

    @Test
    public void contextLoads() {


    }

}
