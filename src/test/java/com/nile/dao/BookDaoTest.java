package com.nile.dao;

import com.nile.entity.Author;
import com.nile.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void selectBookById() throws Exception {
        Book book = bookDao.selectBookById(1);
        List<Author> authors = book.getAuthors();
        System.out.println(book.toString());
        if (authors != null && authors.size() > 0) {
            for (Author author : authors) {
                System.out.println(author.getId());
                System.out.println(author.getName());
            }
        }
    }

    @Test
    public void selectBookAll() throws Exception {

    }

    @Test
    public void insertBook() throws Exception {

    }

    @Test
    public void updateBook() throws Exception {

    }

    @Test
    public void deleteBook() throws Exception {

    }

}