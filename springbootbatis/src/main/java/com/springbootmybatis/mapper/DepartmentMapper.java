package com.springbootmybatis.mapper;

import com.springbootmybatis.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {
    //查询
    @Select("select * from department where id=#{id}")
    public Department getDepartment(Integer id);
    //删除
    @Delete("delete from deparment where id=#{id}")
    public int delectDepaById(Integer id);
    //插入
    @Options(useGeneratedKeys = true,keyProperty = "id") //表示id属性是自增
    @Insert("insert into department (name) values(#{name})")
    public int insertDepa(Department department);
    //修改
    @Update("update department set name=#{name} where id=#{id}")
    public int updateDapa(Department department);
}
