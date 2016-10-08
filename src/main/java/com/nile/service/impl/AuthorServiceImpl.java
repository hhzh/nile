package com.nile.service.impl;

import com.nile.dao.AuthorDao;
import com.nile.entity.Author;
import com.nile.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author selectAuthorById(Integer id) {
        return authorDao.selectAuthorById(id);
    }

    @Override
    public List<Author> selectAuthorAll() {
        return authorDao.selectAuthorAll();
    }

    @Override
    public void insertAuthor(Author author) {
        authorDao.insertAuthor(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorDao.deleteAuthor(id);
    }
}
