package com.learn.dao;

import com.learn.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     @Transactional(propagation = Propagation.SUPPORTS)
     public int updateUser(User user){

         return jdbcTemplate.update("update user set money=? where id=?",user.getMoney(),user.getId());
     }


}
