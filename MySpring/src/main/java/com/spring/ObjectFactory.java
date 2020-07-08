package com.spring;

public class ObjectFactory {
    public UserEntity getUserEntity(){
            System.out.println("实例工厂方法执行了。。。");
            return new UserEntity("haha",22);
        }

        public static UserEntity StaticUserEntity(){
            System.out.println("静态工厂方法执行了。。。");
            return new UserEntity("xx",23);
    }
}
