package com.learn.xml.dao;

import com.learn.xml.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     public int updateUser(User user){

         return jdbcTemplate.update("update user set money=? where id=?",user.getMoney(),user.getId());
     }


}
