package com.nile.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.List;

public class UpdateBookFilter {

    private Integer bookAuthorId;
    private String name;
    private BigDecimal price;
    private List<UpdateBookAuthorFilter> bookAuthorFilters;
    private List<UpdateBookCategoryFilter> bookCategoryFilters;
    private Publisher publisher;

    public Integer getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(Integer bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<UpdateBookAuthorFilter> getBookAuthorFilters() {
        return bookAuthorFilters;
    }

    public void setBookAuthorFilters(List<UpdateBookAuthorFilter> bookAuthorFilters) {
        this.bookAuthorFilters = bookAuthorFilters;
    }

    public List<UpdateBookCategoryFilter> getBookCategoryFilters() {
        return bookCategoryFilters;
    }

    public void setBookCategoryFilters(List<UpdateBookCategoryFilter> bookCategoryFilters) {
        this.bookCategoryFilters = bookCategoryFilters;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
