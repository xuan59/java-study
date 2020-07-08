package com.springbootcache.mapper;

import com.springbootcache.bean.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from users where id=#{id}")
    public Users getUser(Integer id);

    @Update("update users set name=#{name},age=#{age},email=#{email},sex=#{sex},department=#{department} where id=#{id}")
    public void updateUser(Users users);

    @Delete("delete from users where id=#{id}")
    public void deleteUser(Integer id);

    @Insert("insert into users(name,age,email,sex,department) values(#{name},#{age},#{email},#{sex},#{department})")
    public void insertUser(Users users);
}
