package com.nile.dao;

import com.nile.entity.Author;
import com.nile.entity.Book;
import com.nile.entity.Category;
import com.nile.entity.Publisher;
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
        Book book = bookDao.selectBookById(3);
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
        List<Book> books=bookDao.selectBookAll();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void insertBook() throws Exception {
        Book book=new Book();
        book.setName("红楼梦");
        book.setPrice(new BigDecimal(89));
        List<Author> authors = new ArrayList<>();
        Author author=new Author();
        author.setName("曹雪芹");
        authors.add(author);
        List<Category> categories = new ArrayList<>();
        Category category=new Category();
        category.setName("文学");
        categories.add(category);
        Publisher publisher=new Publisher();
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

    }

}