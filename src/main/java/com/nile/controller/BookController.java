package com.nile.controller;

import com.nile.entity.Book;
import com.nile.entity.SelectBookFilter;
import com.nile.entity.UpdateBookFilter;
import com.nile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static javafx.scene.input.KeyCode.R;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/hello")
    @ResponseBody
    public ResponseEntity<String> hello() {
        return response("hello", "Hello");
    }

    @RequestMapping("/select")
    @ResponseBody
    public ResponseEntity<String> selectBookById(Integer id) {
        Book book = bookService.selectBookById(id);
        System.out.println(book);
        return response("book", book);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public ResponseEntity<String> selectBookAll() {
        List<Book> books = bookService.selectBookAll();
        return response("books", books);
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> selectBookByFilter(@RequestBody SelectBookFilter filter) {
        List<Book> books = bookService.selectBookByFilter(filter);
        System.out.println(books);
        return response("books", books);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateBookByFilter(@RequestBody UpdateBookFilter filter) {
        bookService.updateBook(filter);
        return response();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> deleteBookById(Integer id) {
        bookService.deleteBook(id);
        return response();
    }

}
