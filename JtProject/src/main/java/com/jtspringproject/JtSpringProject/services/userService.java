package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.models.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtspringproject.JtSpringProject.dao.userDao;
import com.jtspringproject.JtSpringProject.models.User;

@Service
public class userService {
	@Autowired
	private userDao userDao;
	
	public List<User> getUsers(){
		return this.userDao.getAllUser();
	}
	
	public User addUser(User user) {
		return this.userDao.saveUser(user);
	}
	public String getAdminMail(){ return this.userDao.getAdminMail();}
	public boolean isUserUnique(User user) { return this.userDao.isUsernameUnique(user);	}
	public boolean isEmailUnique(User user) { return this.userDao.isEmailUnique(user);	}
	public User checkLogin(String username, String password) {
		return this.userDao.getUser(username, password);
	}

	
}
