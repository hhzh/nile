package com.nile.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

public class Author {

    private Integer id;
    private String name;
    private String profile;
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
