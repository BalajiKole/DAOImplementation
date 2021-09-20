package com.service;

import java.util.Set;

import com.dao.UserDao;

import com.model.User;

public class UserServiceImplementation implements UserService{
	

	UserDao dao;
     
    

	public UserServiceImplementation(UserDao dao) {
		super();
		this.dao = dao;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public User getUserByUserNameAndPassword(String user,String pass) {
		// TODO Auto-generated method stub
		return dao.getUserByUserNameAndPassword(user,pass);
	}

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return dao.insertUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}

}
