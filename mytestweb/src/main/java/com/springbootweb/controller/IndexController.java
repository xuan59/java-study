package com.springbootweb.controller;
import com.springbootweb.bean.Department;
import com.springbootweb.bean.Users;
import com.springbootweb.componet.LoginHandlerIntercepor;
import com.springbootweb.dao.DepartmentDao;
import com.springbootweb.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class IndexController {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/")
    public String index() {
        return "login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/index")
    public String main(){
        return "index";
    }

    //查询用户所有信息
    @GetMapping("/user")
    public String user(ModelMap map){
//        String sql = "select * from users";
//        List<Users> usersList = jdbcTemplate.query(sql,new RowMapper<Users>(){
//            Users users = null;
//            Department department = new Department();
//            @Override
//            public Users mapRow(ResultSet rs, int rowNum) throws SQLException{
//                users = new Users();
//                users.setId(rs.getInt("id"));
//                users.setName(rs.getString("name"));
//                users.setAge(rs.getInt("age"));
//                users.setEmail(rs.getString("email"));
//                users.setGender(rs.getString("gender"));
//                department.setDepartmentName(rs.getString("department"));
//                department.setId(1);
//                users.setDepartment(rs.getString("department"));
//                users.setBirth(rs.getDate("birth"));
//                return users;
//            }
//        });
//        for (Users user:usersList) {
//            System.out.println(user);
//        }

        List<Users> all = userRepository.findAll();

        map.addAttribute("users",all);
        return "UserList";
    }


    @GetMapping("/add")
    public String add(ModelMap map){
        //Users user = userRepository.getOne(2);
        List<Department> departments = departmentDao.findAll();
        map.addAttribute("departments",departments);
        //map.addAttribute("user",user);
        return "addUser";
    }
    @PostMapping("/insert")
    public String insert(@RequestParam("name")String name,
                         @RequestParam("age")int age,
                         @RequestParam("sex")String sex,
                         @RequestParam("email")String email,
                         @RequestParam("department")String department,
                         @RequestParam("birth") String birth){
        Users user = new Users();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setDepartment(department);
        user.setEmail(email);
        //users.setBirth(birth);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirth(dateFormat.parse(birth));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("异常");
        }
        userRepository.save(user);
        return "redirect:user";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam("id")int id,ModelMap map){
        Users user = userRepository.getOne(id);
//        System.out.println("查询的记录:"+user);
        List<Department> departments = departmentDao.findAll();
//        System.out.println("查询的部门"+departments);
        map.addAttribute("departmens",departments);
        map.addAttribute("user",user);
        return "update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id")int id,
                         @RequestParam("name")String name,
                         @RequestParam("age")int age,
                         @RequestParam("sex")String sex,
                         @RequestParam("email")String email,
                         @RequestParam("department")String department,
                         @RequestParam("birth") String birth){
        Users user = userRepository.getOne(id);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setDepartment(department);
        user.setEmail(email);
        //user.setBirth(birth);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirth(dateFormat.parse(birth));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("异常");
        }
        userRepository.save(user);
        return "redirect:user";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id,ModelMap map){
        userRepository.deleteById(id);
        List<Users> all = userRepository.findAll();
        map.addAttribute("users",all);
        return "redirect:user";
    }

    @GetMapping("/search")
    public String search(@RequestParam("id")Integer id,ModelMap map){
        Optional<Users> byId = userRepository.findById(id);
        if(byId.isPresent()){
            Users user = userRepository.findById(id).get();
            System.out.println(user);
            List<Users>  users = new ArrayList<>();
            users.add(user);
            for (Users u:users) {
                System.out.println("user:"+u);
            }
            map.addAttribute("users",users);
        }else{
           map.addAttribute("unuser","没有匹配记录");
        }
        map.addAttribute("search",id);
        return "UserList";
    }

    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginHandlerIntercepor()).addPathPatterns("/**").excludePathPatterns("login","/");
    }
}
