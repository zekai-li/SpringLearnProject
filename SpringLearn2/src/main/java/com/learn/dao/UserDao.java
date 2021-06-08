package com.learn.dao;

import com.learn.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements BaseDao<User> {
    public UserDao() {
        System.out.println("userDao....");
    }

    @Override
    public void saveEntity(User user) {
        System.out.println("userDao..添加用户"+user);
    }
}
