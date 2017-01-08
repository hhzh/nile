package com.nile.dao;

import com.nile.entity.Book;
import com.nile.entity.SelectBookFilter;
import com.nile.entity.UpdateBookFilter;

import java.util.List;

public interface BookDao {

    public Book selectBookById(Integer id);

    public List<Book> selectBookByFilter(SelectBookFilter filter);

    public List<Book> selectBookAll();

    public void insertBook(Book book);

    public void insertBatchBook(List<Book> books);

    public void updateBook(UpdateBookFilter filter);

    public void deleteBook(Integer id);
}
