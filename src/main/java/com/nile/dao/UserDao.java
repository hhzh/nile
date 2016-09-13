package com.nile.dao;

import com.nile.entity.User;

public interface UserDao {

    public User selectUserById(int id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUserById(int id);

}
