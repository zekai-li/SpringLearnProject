package com.learn.dao;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoChild extends PersonDao {
    public PersonDaoChild() {
        System.out.println("PersonDaoChild");
    }
}
