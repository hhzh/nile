package com.nile.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void selectBookById() throws Exception {
        Book book = bookDao.selectBookById(1);
        String s = JSON.toJSONStringWithDateFormat(book, "YYYY-MM-DD hh:mm:ss", SerializerFeature.PrettyFormat);
        System.out.println(book);
        System.out.println(s);
    }

    @Test
    public void selectBookAll() throws Exception {
        List<Book> books = bookDao.selectBookAll();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void insertBook() throws Exception {
        Book book = new Book();
        book.setName("红楼梦");
        book.setPrice(new BigDecimal(89));
        List<Author> authors = new ArrayList<>();
        Author author = new Author();
        author.setName("曹雪芹");
        authors.add(author);
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setName("文学");
        categories.add(category);
        Publisher publisher = new Publisher();
        publisher.setName("中国文学出版社");
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
    }

    @Test
    public void updateBook() throws Exception {

    }

    @Test
    public void deleteBook() throws Exception {
        bookDao.deleteBookById(1);
    }

}