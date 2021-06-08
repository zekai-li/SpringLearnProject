package com.learn.controller;

import com.learn.bean.Person;
import com.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    public PersonController(){
        System.out.println("PersonController....");
    }
    @Autowired
    private PersonService personService;
    public void save(){
        System.out.println("personController...save");
         personService.save(new Person());

    }


}
