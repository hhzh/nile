package com.nile.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class UpdateBookAuthorFilter {

    private Integer id;
    private Integer oldBookId;
    private Integer newBookId;
    private Integer oldAuthorId;
    private Integer newAuthorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOldAuthorId() {
        return oldAuthorId;
    }

    public void setOldAuthorId(Integer oldAuthorId) {
        this.oldAuthorId = oldAuthorId;
    }

    public Integer getNewAuthorId() {
        return newAuthorId;
    }

    public void setNewAuthorId(Integer newAuthorId) {
        this.newAuthorId = newAuthorId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
