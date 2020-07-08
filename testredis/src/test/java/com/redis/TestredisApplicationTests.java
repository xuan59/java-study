package com.redis;

import com.redis.bean.User;
import com.redis.utils.redisUtls;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestredisApplicationTests {

    @Test
    public void contextLoads() {
        /*
        * 连接redis
        * */
        String host = "192.168.43.96";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.close();
    }

    @Test
    public void testSring(){
        //连接redis
        Jedis jedis = new Jedis("192.168.43.96",6379);
        jedis.auth("123456");

        //操作字符串
        jedis.set("strName","小宝贝");
        System.out.println(jedis.get("strName"));

        jedis.close();

    }

    @Test
    public void testString2(){
        //连接redis
        Jedis jedis = redisUtls.getJedis();
        String key = "strName";
        if (jedis.exists(key)){
            System.out.println("从redis中查找:"+jedis.get(key));
        }else{
            System.out.println("从数据库中查找：");

        }

        redisUtls.close(jedis);
    }
    @Test
    public void testHash(){
        //连接redis
        Jedis jedis = redisUtls.getJedis();
        String key = "user";
        if (jedis.exists(key)){
            Map<String,String> map = jedis.hgetAll(key);
            System.out.println("从redis中查找:"+map.toString());
        }else{

            User user = new User();
            user.setId(1);
            user.setName("乖乖");
            user.setSex("女");
            user.setAge(18);
            System.out.println("从数据库中查找："+user);
            Map<String,String> map = new HashMap<String, String>();
            map.put("id",user.getId()+"");
            map.put("name",user.getName());
            map.put("sex",user.getSex());
            map.put("age",user.getAge()+"");
            jedis.hmset(key,map);

        }

        redisUtls.close(jedis);
    }

}
