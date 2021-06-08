package com.learn.xml.service;

import com.learn.xml.bean.Book;
import com.learn.xml.bean.User;
import com.learn.xml.dao.BookDao;
import com.learn.xml.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookService {
     @Autowired
     private UserDao userDao;
     @Autowired
     private BookDao bookDao;


    public void updateUserBook(){

        userDao.updateUser(new User(1,"zhangsan",600));//单独支持事务特性的(小事务)
          System.out.println(1/0);
        bookDao.updateBook(new Book(1,null,98));//单独支持事务特性(小事务)


    }

}
