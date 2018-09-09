package com.wym.springboot01.service;

import java.util.List;

import com.wym.springboot01.bean.User;

public interface UserService {
	
	
	int addUser(User user);
	int updateUser(User user);
	List<User> getUsers();
	User getUserByID(int id);
	int deleteUser(int id);

}
