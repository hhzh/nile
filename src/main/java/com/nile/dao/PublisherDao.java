package com.nile.dao;

import com.nile.entity.Publisher;

import java.util.List;

public interface PublisherDao {

    public Publisher selectPublisherById(Integer id);

    public List<Publisher> selectPublisherAll();

    public void insertPublisher(Publisher publisher);

    public void updatePublisher(Publisher publisher);

    public void deletePublisher(Integer id);
}
