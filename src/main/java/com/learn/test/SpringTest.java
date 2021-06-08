package com.learn.test;

import com.learn.bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void t1(){
/*
        Person person=new Person();//对象创建使用new关键字(通过java程序创建对象)
        //但是程序中添加了spring框架  (IOC控制反转)  把对象的创建任务交给spring容器

        person.setName("张三");
        person.getName();
*/

        //创建spring的容器(读取applicationContext.xml文件)
        // context 容器对象的名字
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");

       //从容器中获取p1的对象 缺点: 必须强转
       // Person person=(Person) context.getBean("p1");
        //根据容器中管理bean对象的类型获取资源  缺点: 类型容器重复(报错)
       // Person person2 = context.getBean(Person.class);
        //根据类型和当前容器中bean对象的名字获取资源

      /*  Person person2 = context.getBean("p14", Person.class);*/

  /*      Person person = context.getBean("p15", Person.class);
        System.out.println(person);*/
       /* System.out.println(person2);*/
     /*   A a1 = context.getBean(A.class);
        A a2 = context.getBean(A.class);
        System.out.println(a1);
        System.out.println(a2);*/
        Person person = context.getBean("p17",Person.class);
        System.out.println(person);
        System.out.println("3.使用person对象");
        context.close();

    }

}
