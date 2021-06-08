package com.learn.factory;

import com.learn.bean.Person;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean  implements FactoryBean<Person> {

    // 创建person 对象
    @Override
    public Person getObject() throws Exception {
        return new Person(14,"大壮","111",20);
    }

    //返回当前实例的类型
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    //设置当前实例是否是单例的
    @Override
    public boolean isSingleton() {
        return false;
    }
}
