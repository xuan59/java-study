package com.springbootmybatis.controller;

import com.springbootmybatis.bean.Department;
import com.springbootmybatis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class DapaController {
    @Autowired
    DepartmentMapper departmentMapper;
    @ResponseBody
    @GetMapping("/getdepa/{id}")
    /*@GetMapping("/getdepa/{id}")
    * @PathVariable("id")*/
    public Department getDapartment(@PathVariable("id") Integer id){
        Department department = departmentMapper.getDepartment(id);
        System.out.println(department);
        return department;
    }
    @ResponseBody
    @GetMapping("/indepa")
    public Department insertDepa(Department department){
        departmentMapper.insertDepa(department);
        System.out.println(department);
        return department;
    }
}
