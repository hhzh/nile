package com.nile.controller;

import com.nile.entity.Book;
import com.nile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/select")
    @ResponseBody
    public ResponseEntity<String> selectBookById(Integer id) {
        Book book = bookService.selectBookById(id);
        return response(book);
    }

}
