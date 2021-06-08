package com.learn.service;

import com.learn.bean.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book> {
    public BookService() {
        System.out.println("bookService...");
    }
}
