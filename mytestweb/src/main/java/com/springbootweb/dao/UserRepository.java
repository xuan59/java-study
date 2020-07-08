package com.springbootweb.dao;


import com.springbootweb.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
//    List<Users> findAll();
//
//    Users findBy(Integer id);
//
//    void deleteById(Integer id);
//
//    void update(Users account);
//
//    void add(Users account);
}
