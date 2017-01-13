package com.nile.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class BookCategory {

    private Integer id;
    private Integer bookId;
    private Integer categoryId;

    public BookCategory() {

    }

    public BookCategory(Integer bookId, Integer categoryId) {
        this.bookId = bookId;
        this.categoryId = categoryId;
    }

    public BookCategory(Integer id, Integer bookId, Integer categoryId) {
        this.id = id;
        this.bookId = bookId;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}