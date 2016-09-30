package com.nile.dao;

import com.nile.entity.Author;

import java.util.List;

public interface AuthorDao {

    public Author selectAuthorById(Integer id);

    public List<Author> selectAuthorAll();

    public void insertAuthor(Author author);

    public void updateAuthor(Author author);

    public void deleteAuthor(Integer id);
}
