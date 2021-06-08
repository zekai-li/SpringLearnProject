package com.learn.xml.dao;

import com.learn.xml.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int updateBook(Book book){

        return jdbcTemplate.update("update book set stock=? where id=? ",book.getStock(),book.getId());
    }

}
