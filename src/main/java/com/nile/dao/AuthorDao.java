package com.nile.dao;

import com.nile.entity.Author;

import java.util.List;

public interface AuthorDao {

    Author selectAuthorById(Integer id);

    Author selectAuthorByName(String name);

    List<Author> selectAuthorAll();

    void insertAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Integer id);
}
