package com.learn.service;

import com.learn.bean.Person;
import com.learn.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public PersonService(){
        System.out.println("personService...");
    }
    /*

    *@Autowired 到spring容器中查找personDao
         byType  是默认的 (在spring容器中查找bean的类型和当前类(PersonService)中属性的类型是否一致,如果一致装配成功,注意: 类型不能匹配多个)
         byName   @Qualifier 通过名字匹配
         先按照类型匹配如果匹配失败再按照名字匹配


     */

    @Autowired
    @Qualifier("pd")
    private PersonDao personDao;
    //获取容器中的对象1.getBean 2.自动注入 autoWire

    public void save(Person person){
        System.out.println("personService save 方法");
        personDao.save(person);

    }

}
