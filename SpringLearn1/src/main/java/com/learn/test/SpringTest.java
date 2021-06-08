package com.learn.test;

import com.learn.controller.PersonController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class SpringTest {
    @Test
    public void t1() throws SQLException {
      /*  ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
*//*

        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection.isClosed());
*//*
        Person bean = context.getBean(Person.class);
        System.out.println(bean);*/




        ApplicationContext context=new ClassPathXmlApplicationContext("bean3.xml");
      /*  PersonDao personDao = context.getBean("pd",PersonDao.class);
        PersonDao personDao2 = context.getBean("pd",PersonDao.class);
        System.out.println(personDao);
        System.out.println(personDao2);*/
        PersonController personController = context.getBean(PersonController.class);
        personController.save();


    }
}
