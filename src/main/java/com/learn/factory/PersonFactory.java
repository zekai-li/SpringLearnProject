package com.learn.factory;

import com.learn.bean.Person;

/**
 * 创建person对象的工厂类
 */
public class PersonFactory {
    //静态方法
    public static Person createPerson1(){

        return new Person(12,"jack","111",20);
    }


    //实例方法
    public  Person createPerson2(){

        return new Person(13,"rose","111",20);
    }
}
