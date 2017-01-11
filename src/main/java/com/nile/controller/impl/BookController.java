package com.nile.controller.impl;

import com.nile.controller.BaseController;
import com.nile.controller.IBookController;
import com.nile.entity.Book;
import com.nile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BookController extends BaseController implements IBookController{

    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<String> selectBookById(Integer id) {
        Book book = bookService.selectBookById(id);
        return response(book);
    }

}
