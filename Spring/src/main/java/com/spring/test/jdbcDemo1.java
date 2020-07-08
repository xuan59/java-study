package com.spring.test;

import java.sql.*;

/*
* 程序的耦合
*    程序间的依赖，包括 类之间的关系 和 方法之间的关系
*
*   解耦：降低程序间的依赖关系，再实际开发中要做到编译期不依赖，运行时才依赖
*
* 以下方法独立性很差，编译期进行依赖
*
* 解耦思路：
*   1.使用反射来创建对象，避免使用new来创建
*   2.通过读取配置文件来获取需要创建的对象
* */
public class jdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        //1、注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2、获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","123456");
        //3、获取操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users");
        //4、执行SQL，得到结果
        ResultSet rs = preparedStatement.executeQuery();
        //5、遍历
        while (rs!=null&rs.next()){
            System.out.println(rs.getString(2));
        }
        //6、释放资源
        rs.close();
        preparedStatement.close();
        connection.close();
    }
}
