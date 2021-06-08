package com.learn.jdbc;

import com.learn.bean.Employee;
import com.learn.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.*;

@ContextConfiguration("classpath:beanJdbc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTemplateTest {

     @Autowired
    private JdbcTemplate jdbcTemplate;
     @Autowired
     private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
     @Autowired
     private EmployeeDao employeeDao;

     @Test
    public  void t1(){
    //将id=5的记录的salary字段更新为1300.00
         int row = jdbcTemplate.update("update employee set salary=? where id=?", new BigDecimal(1300.01), 5);
         System.out.println(row);
     }

    @Test
    public  void t2(){
        //批量插入 员工信息
        List<Object[]> emps=new ArrayList<>();
        emps.add(new Object[]{"好酒",300});
        emps.add(new Object[]{"好诗",3000});
        emps.add(new Object[]{"双十一",30000});

        int[] ints = jdbcTemplate.batchUpdate("insert into employee values(null,?,?)", emps);
        System.out.println(Arrays.toString(ints));
    }

    //查询id=5的数据库记录，封装为一个Java对象返回
    //查询单条 queryForObject
    @Test
    public  void t3(){
        Employee employee = jdbcTemplate.queryForObject("select * from employee where id=?", new BeanPropertyRowMapper<>(Employee.class), 5);
        System.out.println(employee);
    }

    //查询salary>4000的数据库记录，封装为List集合返回
    //查询多条  query
    @Test
    public  void t4(){
        List<Employee> employees = jdbcTemplate.query("select * from employee where salary>?", new BeanPropertyRowMapper<>(Employee.class), 4000);
        System.out.println(employees);

    }
    //查询最大salary   查询当行单列数据 使用 queryForObject
    @Test
    public  void t5(){
        BigDecimal maxSalary = jdbcTemplate.queryForObject("select max(salary) from employee", BigDecimal.class);
        System.out.println(maxSalary);
    }

    //实验6：使用带有命名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
    @Test
    public  void t6(){
        Map<String,Object> params=new HashMap<>();
        params.put("name","双十二");
        params.put("salary",20000);

        int update = namedParameterJdbcTemplate.update("insert into employee values(null,:name,:salary)", params);
        System.out.println(update);
    }

    @Test
    public  void t7(){
        Employee emp = employeeDao.getEmpById(5);
        System.out.println(emp);

    }
}
