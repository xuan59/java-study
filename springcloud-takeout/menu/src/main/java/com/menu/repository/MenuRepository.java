package com.menu.repository;

import com.menu.bean.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Query(value = "select id,name,price,flavor,type from menu where name like %:search% or flavor like %:search%",nativeQuery = true)
    public List<Menu> findMenuAll(String search);
   /* //public int count();
    public Menu findById();
    //public void save(Menu menu);
    public void update(Menu menu);
    public  void deleteById(int id);*/
}
