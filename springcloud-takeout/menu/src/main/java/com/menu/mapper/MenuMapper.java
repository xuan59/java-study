package com.menu.mapper;

import com.menu.bean.Menu;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MenuMapper {

    @Select("select * from menu")
    public Menu getMenuAll();

    @Select("select * from menu where id=#{id}")
    public Menu getMenuId(Integer id);

    @Update("update menu set name=#{name},price=#{price},flavor=#{flavor},type=#{type} where id=#{id}")
    public void updateMenu(Menu users);

    @Delete("delete from menu where id=#{id}")
    public void deleteMenu(Integer id);

    @Insert("insert into menu(name,price,flavor,type) values(#{name},#{price},#{flavor},#{type})")
    public void insertMenu(Menu users);
}
