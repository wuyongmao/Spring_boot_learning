package com.wym.springboot01.service;

import java.util.List;

import com.wym.springboot01.bean.User;

public interface UserService {
	
	
	User addUser(User user) throws Exception;
	User updateUser(User user);
	List<User> getAllUsers();
	List<User> getUsersByName(String name);
 	void deleteUser(int id);
 	int deleteUserById(int id);
	User getUserByID(int id);

}
