package com.jtspringproject.JtSpringProject.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.dao.userDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class userServiceAddedTest {

    @Autowired
    userService userService;
    @Autowired
    userDao userDao;
    @Test
    void getAdminMail() {
        assertEquals(userService.getAdminMail(),userDao.getAdminMail());
    }

    @Test
    void isUserUnique() {
        User user=new User();
        user.setUsername("Emily");
        assertEquals(userService.isUserUnique(user),userDao.isUsernameUnique(user));
        user.setUsername("lisa");
        assertEquals(userService.isUserUnique(user),userDao.isUsernameUnique(user));
    }

    @Test
    void isEmailUnique() {
        User user=new User();
        user.setEmail("lisa@gmail.com");
        assertEquals(userService.isEmailUnique(user),userDao.isEmailUnique(user));
        user.setUsername("abc@yahoo.com");
        assertEquals(userService.isEmailUnique(user),userDao.isEmailUnique(user));
    }
}