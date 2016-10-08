package com.nile.service;

import com.nile.entity.Book;

import java.util.List;

public interface BookService {

    public Book selectBookById(Integer id);

    public List<Book> selectBookAll();

    public void insertBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(Integer id);
}
