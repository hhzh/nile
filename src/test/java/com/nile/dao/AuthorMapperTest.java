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
        int i = authorMapper.deleteByPrimaryKey(4);
        System.out.println("i="+i);
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
        Author author = new Author();
        author.setName("莫言");
        author.setProfile("诺贝尔文学奖获得者");
        authorMapper.insert(author);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Author author = authorMapper.selectByPrimaryKey(1);
        System.out.println(author);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Author author = new Author();
        author.setId(5);
        author.setProfile("中国著名作家");
        int i = authorMapper.updateByPrimaryKeySelective(author);
        System.out.println("i="+i);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}