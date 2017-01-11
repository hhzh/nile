package com.nile.dao;

import com.alibaba.fastjson.JSON;
import com.nile.entity.Publisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PublisherDaoTest extends BaseTest{

    @Autowired
    private PublisherDao publisherDao;

    @Test
    public void selectPublisherById() throws Exception {
        Publisher publisher = publisherDao.selectPublisherById(1);
        String s = JSON.toJSONString(publisher);
        System.out.println(publisher);
        System.out.println(s);
    }

    @Test
    public void selectPublisherAll() throws Exception {

    }

    @Test
    public void insertPublisher() throws Exception {

    }

    @Test
    public void updatePublisher() throws Exception {

    }

    @Test
    public void deletePublisher() throws Exception {

    }

}