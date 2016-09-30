package com.nile.service;

import com.nile.entity.User;

import java.util.List;

public interface UserService {

    public User selectUserById(int id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUserById(int id);

    public List<User> selectAll();

}
