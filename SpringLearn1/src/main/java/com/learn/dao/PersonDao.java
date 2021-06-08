package com.learn.dao;

import com.learn.bean.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @Repository  数据访问层
 * 作用等价于  <bean id="" class="com.atguigu.dao.PersonDao"></bean> 创建bean对象
 *
 * 当前id值默认是类名首字母小写 personDao
 *
 *
 */
@Repository("pd")
   /* @Component("pd")*/
@Scope("prototype")
public class PersonDao {
    public PersonDao(){
        System.out.println("personDao.....");
    }

    public void save(Person person){
        System.out.println("personDao..."+person);
    }



}
