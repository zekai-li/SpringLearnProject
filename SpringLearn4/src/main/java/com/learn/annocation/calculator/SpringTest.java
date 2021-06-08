package com.learn.annocation.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    private  CaclulatorImpl calculator;
    @Test
    public void t1(){
         calculator.div(1,1);

    }

    @Test
    public void t2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = ctx.getBean(Calculator.class);
    }


}
