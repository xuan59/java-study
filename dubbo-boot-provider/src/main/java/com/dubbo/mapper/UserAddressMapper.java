package com.dubbo.mapper;

import com.dubbo.bean.UserAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserAddressMapper {
    @Select("select * from useraddress where userid=#{userId}")
    public List<UserAddress> getUserAddress(String userId);

    @Update("update useraddress set address=#{userAddress},consignee=#{consignee},phone=#{phoneNum},isDefault=#{isDefault} where id=#{id}")
    public void updateUserAddress(UserAddress userAddress);

    @Delete("delete from useraddress where id=#{id}")
    public void deleteUserAddress(String id);

    @Insert("insert into useraddress(address,userid,consignee,phone,isDefault) values(#{userAddress},#{userId},#{consignee},#{phoneNum},#{isDefault})")
    public void insertUserAddress(UserAddress userAddress);
}
