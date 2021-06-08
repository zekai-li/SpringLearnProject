package com.learn.factory;

import com.learn.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在执行初始化之前执行....");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化方法执行之后...");
        if(beanName.equals("p17")){
            Person person=(Person)bean;
             person.setName("小红");
             return person;
        }
        return bean;
    }
}
