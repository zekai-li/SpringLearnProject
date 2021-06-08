package com.learn.dao;

import com.learn.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao implements BaseDao<Book> {
    public BookDao() {
        System.out.println("BooDao...");
    }

    @Override
    public void saveEntity(Book book) {
        System.out.println("添加图书信息"+book);
    }
}
