package com.nile.service;

import com.nile.entity.Book;
import com.nile.entity.UpdateBookFilter;

import java.util.List;

public interface BookService {

    public Book selectBookById(Integer id);

    public List<Book> selectBookAll();

    public void insertBook(Book book);

    public void updateBook(UpdateBookFilter filter);

    public void deleteBook(Integer id);
}
