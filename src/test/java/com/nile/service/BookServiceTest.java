package com.nile.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceTest extends BaseTest{

    @Autowired
    private BookService bookService;

    @Test
    public void selectBookById() throws Exception {
        Book book = bookService.selectBookById(1);
        System.out.println(book);
    }

    @Test
    public void selectBookAll() throws Exception {

    }

    @Test
    public void insertBook() throws Exception {

    }

    @Test
    public void updateBook() throws Exception {

    }

    @Test
    public void deleteBook() throws Exception {

    }

}