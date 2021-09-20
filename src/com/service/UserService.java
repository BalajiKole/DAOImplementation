package com.service;

import java.util.Set;

import com.model.User;

public interface UserService {

	User getUser(int id);
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword(String user, String pass);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
