package com.nile.dao;

import com.nile.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectUserById() {
        User user = userDao.selectUserById(1000);
        System.out.println(user.toString());
    }

    @Test
    public void testInsertUser() {
        User user=new User();
        user.setName("余秋雨");
        user.setPhone("13822345678");
        userDao.insertUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user=new User();
        user.setId(1000);
        user.setName("Jim");
        user.setPhone("13912346780");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(1002);
    }

    @Test
    public void testSelectAll() {
        List<User> users=userDao.selectAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

}