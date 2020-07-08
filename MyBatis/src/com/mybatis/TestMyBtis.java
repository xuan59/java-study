package com.mybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestMyBtis {
    public static void main(String[] args) throws IOException {
        show();
    }

    public static void show() throws IOException {
        String resource = "mybatis.xml";
        Reader resourceAsReader = Resources.getResourceAsReader(resource);
        //session会话工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession openSession = ssf.openSession();
        String statement = "UserMapper.getUser";
        User user = openSession.selectOne(statement,1);
        System.out.println(user.toString());
        openSession.close();
    }
}
