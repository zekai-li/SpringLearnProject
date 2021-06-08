package com.learn.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void updateUser(){
        System.out.println("业务层修改用户信息");
    }
}
