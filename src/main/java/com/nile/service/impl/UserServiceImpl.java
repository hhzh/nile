package com.nile.service.impl;

import com.nile.dao.UserDao;
import com.nile.entity.User;
import com.nile.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
