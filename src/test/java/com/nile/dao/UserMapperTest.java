package com.nile.dao;

import com.nile.pojo.User;
import com.nile.util.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setPassword(MD5Util.MD5EncodeUtf8("mypassword"));
        user.setPhone("18912345678");
        user.setEmail("zhangsan@gmail@.com");
        user.setQuestion("你的小学班主任是谁？");
        user.setAnswer("李四");
        user.setRole(1);

        userMapper.insertSelective(user);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        User user = new User();
        user.setId(1);
        user.setAnswer("王五");
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println("i="+i);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void checkUsername() throws Exception {
    }

    @Test
    public void checkEmail() throws Exception {
    }

    @Test
    public void selectLogin() throws Exception {
    }

    @Test
    public void selectQuestionByUsername() throws Exception {
    }

    @Test
    public void checkAnswer() throws Exception {
    }

    @Test
    public void updatePasswordByUsername() throws Exception {
    }

    @Test
    public void checkPassword() throws Exception {
    }

    @Test
    public void checkEmailByUserId() throws Exception {
    }

}