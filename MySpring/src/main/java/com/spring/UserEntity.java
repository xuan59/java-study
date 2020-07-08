package com.spring;

public class UserEntity {
    private String name;
    private Integer age;
    public UserEntity(){
        System.out.println("无参构造函数被调用了。。。");
    }
    public UserEntity(String name ,Integer age){
        System.out.println("有参构造函数被调用了。。。");
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
