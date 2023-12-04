package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.User;


@Repository
public class userDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
   @Transactional
    public List<User> getAllUser() {
        Session session = this.sessionFactory.getCurrentSession();
		List<User>  userList = session.createQuery("from CUSTOMER").list();
        return userList;
    }
	@Transactional
	public String getAdminMail(){
		Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where role=:role");
		query.setParameter("role", "ROLE_ADMIN");
		try {
			User user = (User) query.getSingleResult();
			System.out.println(user.getEmail());
				return user.getEmail();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return "";
		}
	}
	@Transactional
	public boolean isEmailUnique(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where email = :email");
		query.setParameter("email", user.getEmail());

		try {
			query.getSingleResult();
				System.out.println("Already exists");
				return false;
		} catch (Exception e) {
			System.out.println("Error checking email uniqueness: " + e.getMessage());
			System.out.println("Unique Email");
			return true;  // Return false in case of an exception.
		}
	}
	@Transactional
	public boolean isUsernameUnique(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username = :username");
		query.setParameter("username", user.getUsername());

		try {
			query.getSingleResult();
			System.out.println("Already exists");
			return false;
		} catch (Exception e) {
			System.out.println("Error checking username uniqueness: " + e.getMessage());
			System.out.println("Unique Username");
			return true;  // Return false in case of an exception.
		}
	}
    @Transactional
	public User saveUser(User user) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("User added" + user.getId());
        return user;
	}
    
//    public User checkLogin() {
//    	this.sessionFactory.getCurrentSession().
//    }
    @Transactional
    public User getUser(String username,String password) {
    	Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username = :username");
    	query.setParameter("username",username);
    	
    	try {
			User user = (User) query.getSingleResult();
			System.out.println(user.getPassword());
			if(password.equals(user.getPassword())) {
				return user;
			}else {		
				return new User();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			User user = new User();
			return user;
		}
    	
    }
}
