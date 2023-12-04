package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userDaoAddedMethodsTest {

    @Autowired
    userDao userDao;
    @Test
    void getAdminMail() {
        assertEquals("admin@nyan.cat", userDao.getAdminMail());
    }

    @Test
    void isEmailUnique() {
        User user = new User();
        user.setEmail("lisa@gmail.com");
        assertFalse(userDao.isEmailUnique(user));
        user.setEmail("maria@gmail.com");
        assertTrue(userDao.isEmailUnique(user));
    }

    @Test
    void isUsernameUnique() {
        User user = new User();
        user.setUsername("Emily");
        assertTrue(userDao.isUsernameUnique(user));
        user.setUsername("lisa");
        assertFalse(userDao.isUsernameUnique(user));
    }
 }
