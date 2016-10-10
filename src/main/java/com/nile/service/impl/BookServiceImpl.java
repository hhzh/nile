package com.nile.service.impl;

import com.nile.dao.AuthorDao;
import com.nile.dao.BookDao;
import com.nile.dao.CategoryDao;
import com.nile.dao.PublisherDao;
import com.nile.entity.Author;
import com.nile.entity.Book;
import com.nile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private PublisherDao publisherDao;

    @Override
    public Book selectBookById(Integer id) {
        return bookDao.selectBookById(id);
    }

    @Override
    public List<Book> selectBookAll() {
        return null;
    }

    @Override
    public void insertBook(Book book) {
        List<Author> authors=book.getAuthors();
        for (Author author : authors) {
            Author authorResult = authorDao.selectAuthorByName(author.getName());
            if (authorResult == null) {
                Author authorNew = new Author();
                authorNew.setName(author.getName());
                authorDao.insertAuthor(authorNew);
            } else {

            }
        }
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Integer id) {

    }
}
