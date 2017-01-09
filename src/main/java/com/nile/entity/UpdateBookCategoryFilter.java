package com.nile.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UpdateBookCategoryFilter {

    private Integer bookCategoryId;
    private Integer oldBookId;
    private Integer newBookId;
    private Integer oldCategoryId;
    private Integer newCategoryId;

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Integer getOldBookId() {
        return oldBookId;
    }

    public void setOldBookId(Integer oldBookId) {
        this.oldBookId = oldBookId;
    }

    public Integer getNewBookId() {
        return newBookId;
    }

    public void setNewBookId(Integer newBookId) {
        this.newBookId = newBookId;
    }

    public Integer getOldCategoryId() {
        return oldCategoryId;
    }

    public void setOldCategoryId(Integer oldCategoryId) {
        this.oldCategoryId = oldCategoryId;
    }

    public Integer getNewCategoryId() {
        return newCategoryId;
    }

    public void setNewCategoryId(Integer newCategoryId) {
        this.newCategoryId = newCategoryId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
