package com.nile.dao;

import com.nile.entity.Book;
import com.nile.entity.BookAuthor;
import com.nile.entity.BookCategory;
import com.nile.entity.SelectBookFilter;
import com.nile.entity.UpdateBookAuthorFilter;
import com.nile.entity.UpdateBookCategoryFilter;
import com.nile.entity.UpdateBookFilter;

import java.util.List;

public interface BookDao {

    public Book selectBookById(Integer id);

    public List<Book> selectBookByFilter(SelectBookFilter filter);

    public List<Book> selectBookAll();

    public void insertBook(Book book);

    public void insertBatchBook(List<Book> books);

    public void insertBookAuthor(BookAuthor bookAuthor);

    public void insertBookCategory(BookCategory bookCategory);

    public void updateBook(UpdateBookFilter filter);

    public void updateBookAuthor(UpdateBookAuthorFilter filter);

    public void updateBookCategory(UpdateBookCategoryFilter filter);

    public void deleteBookById(Integer id);

    public void deleteBookAuthorByBookId(Integer id);

    public void deleteBookCategoryByBookId(Integer id);
}
