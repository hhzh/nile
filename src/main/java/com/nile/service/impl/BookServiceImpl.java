package com.nile.service.impl;

import com.nile.dao.AuthorDao;
import com.nile.dao.BookDao;
import com.nile.dao.CategoryDao;
import com.nile.dao.PublisherDao;
import com.nile.entity.Author;
import com.nile.entity.Book;
import com.nile.entity.BookAuthor;
import com.nile.entity.BookCategory;
import com.nile.entity.Category;
import com.nile.entity.SelectBookFilter;
import com.nile.entity.UpdateBookAuthorFilter;
import com.nile.entity.UpdateBookCategoryFilter;
import com.nile.entity.UpdateBookFilter;
import com.nile.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
        return bookDao.selectBookAll();
    }

    @Override
    public List<Book> selectBookByFilter(SelectBookFilter filter) {
        return bookDao.selectBookByFilter(filter);
    }

    @Override
    public void insertBook(Book book) {
        List<Author> authors=book.getAuthors();
        if (authors != null && authors.size() > 0) {
            for (Author author : authors) {
                bookDao.insertBookAuthor(new BookAuthor(book.getId(),author.getId()));
            }
        }
        List<Category> categories = book.getCategories();
        if (categories != null && categories.size() > 0) {
            for (Category category : categories) {
                bookDao.insertBookCategory(new BookCategory(book.getId(),category.getId()));
            }
        }

        bookDao.insertBook(book);
    }

    @Transactional
    @Override
    public void updateBook(UpdateBookFilter filter) {
        List<UpdateBookAuthorFilter> bookAuthorFilters = filter.getBookAuthorFilters();
        if (bookAuthorFilters != null && bookAuthorFilters.size() > 0) {
            for (UpdateBookAuthorFilter bookAuthorFilter : bookAuthorFilters) {
                bookDao.updateBookAuthor(bookAuthorFilter);
            }
        }

        List<UpdateBookCategoryFilter> bookCategoryFilters = filter.getBookCategoryFilters();
        if (bookCategoryFilters != null && bookCategoryFilters.size() > 0) {
            for (UpdateBookCategoryFilter bookCategoryFilter : bookCategoryFilters) {
                bookDao.updateBookCategory(bookCategoryFilter);
            }
        }
        bookDao.updateBook(filter);
    }

    @Transactional
    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookAuthorByBookId(id);
        bookDao.deleteBookCategoryByBookId(id);
        bookDao.deleteBookById(id);
    }

    @Override
    public void deleteBooAuthorByBookId(Integer id) {
        bookDao.deleteBookAuthorByBookId(id);
    }

    @Override
    public void deleteBookCategoryByBookId(Integer id) {
        bookDao.deleteBookCategoryByBookId(id);
    }
}
