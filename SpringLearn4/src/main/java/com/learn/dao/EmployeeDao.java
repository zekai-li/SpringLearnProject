package com.learn.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.learn.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao  extends JdbcDaoSupport {

     @Autowired
     public void initDataSource(DruidDataSource dataSource){
         this.setDataSource(dataSource);
     }


/*
    @Autowired
    private JdbcTemplate jdbcTemplate;
*/

    public Employee getEmpById(Integer id){

        return getJdbcTemplate().queryForObject("select * from employee where id=?",new BeanPropertyRowMapper<>(Employee.class),id);
    }
}
