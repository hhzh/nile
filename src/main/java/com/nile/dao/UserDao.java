package com.nile.dao;

import com.nile.entity.User;

import java.util.List;

public interface UserDao {

    public User selectUserById(Integer id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Integer id);

    public List<User> selectAll();

}
