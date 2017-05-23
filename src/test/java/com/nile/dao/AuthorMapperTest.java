package com.nile.dao;

import com.nile.pojo.Author;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class AuthorMapperTest extends BaseTest{

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        authorMapper.insert(new Author(40, "杰伦", "一个作家", new Date(), new Date()));
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Author author = authorMapper.selectByPrimaryKey(1);
        System.out.println(author);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}