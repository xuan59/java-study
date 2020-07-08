package com.xy.test;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.jndi.url.dns.dnsURLContext;
import com.xy.bean.Department;
import com.xy.bean.Employee;
import com.xy.dao.DepartmentMapper;
import com.xy.dao.EmployeeMapper;

import sun.print.resources.serviceui;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DepartmentMapper departmentMapper = ioc.getBean(DepartmentMapper.class);
		System.out.println(departmentMapper);
		Department department = new Department();
		department.setName("开发部");
		departmentMapper.insertSelective(department);
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0; i<1000; i++) {
			String name = UUID.randomUUID().toString().substring(0, 5);
			String sex = (int)Math.random()*2==0?"女":"男";
			mapper.insertSelective(new Employee(null, name, sex, "@xy.com", 2));
		}
		System.out.println("执行完成");

	}

}
