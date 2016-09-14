package com.nile.dao;

import com.nile.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testSelectUserById() {
        User user = userDao.selectUserById(1000);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPhone());
        System.out.println(user.getCreateTime());
        System.out.println(user.getUpdateTime());
    }

    @Test
    public void testInsertUser() {
        User user=new User();
        user.setName("Smith");
        user.setPhone("13812345678");
        userDao.insertUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user=new User();
        user.setId(1);
        user.setName("Tony");
        user.setPhone("13912346789");
    }

    @Test
    public void testDeleteUserById() {
        userDao.deleteUserById(1);
    }

}
