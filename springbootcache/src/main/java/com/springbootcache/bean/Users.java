package com.springbootcache.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Users {
    private int id;
    private String name;
    private int age;
    private String email;
    private String sex;
    private String department;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    //private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + sex + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
