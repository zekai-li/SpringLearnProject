package com.learn.test;

import com.learn.bean.User;
import com.learn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:bean.xml")//读取spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Test
    public void t1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
      /*  UserService userService = ctx.getBean(UserService.class);
        userService.saveEntity(new User());*/
    }
    @Autowired
    private UserService userService;

    @Test
    public void t2(){
      userService.saveEntity(new User());
    }


}
