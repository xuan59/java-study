package com.springbootcache.service;

import com.springbootcache.bean.Users;
import com.springbootcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

//@CacheConfig(cacheNames = "user") //如果在这里指定了之后，下面就不需要再指定名称了
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    /*
    * 名称：@Cacheable
    * 功能：将方法的运行结果进行缓存，以后再执行相同的操作，直接从缓存中获取，不用调用该方法
    * 属性：cacheName/value指定名称，可以指定多个，key缓存时使用的key，默认是方法参数的值
    *      cacheManager指定缓存管理器，或者cacheResolver指定获取解析器
    *      condition指定符合条件的情况下才缓存  比如 condition="1>0"
    *      unless否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存，可以获取到结果进行判断
    *      sync是否使用异步模式
    * */

    @Cacheable(cacheNames = "user")
    public Users getUser(Integer id){
        Users user = userMapper.getUser(id);
        System.out.println("查询："+user);
        return user;
    }

    /*
    * 名称：@CachePut
    * 功能：既调用方法，又更新数据，修改了数据库的数据，同时更新缓存
    * 说明：key值需和缓存中的key值一样，否则更新缓存中的数据不是我们想要更新的数据
    *
    * */

    @CachePut(value = "user",key = "#user.id")
    public Users updateUser(Users user){
        userMapper.updateUser(user);
        System.out.println("数据更新了。。。。"+user);
        return user;
    }

    /*
    * 名称：@CacheEvict
    * 功能：清除缓存
    * 说明：可以通过key指定删除某个缓存,allEntries=true 可以删除 user下所有缓存
    *       beforeInvocation=false 清除缓存是否在方法执行之前
    *
    * */

    @CacheEvict(value = "user",key = "#id")
    public void deleteDelete(Integer id){
        userMapper.deleteUser(id);
        System.out.println("删除成功。。。");
    }

    /*
    * 名称：@Caching
    * 功能：可以同时指定多个缓存属性
    * 说明：可以使用 cacheable()，put()，evict()同时指定多个
    * 比如： @Caching(
    *            cacheable(@Cacheable(value="user")),
    *            put(@CachePut(value="user"))
    *       )
    *
    * */

}
