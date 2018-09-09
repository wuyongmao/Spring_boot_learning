package com.wym.springboot01.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wym.springboot01.bean.User;
import com.wym.springboot01.dao.UserDao;
import com.wym.springboot01.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	@Override
	public User addUser(User user) throws Exception  {
 		 
	 
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(int id) {

		  userDao.delete(id);
	}

	@Override
	public List<User> getAllUsers() {

		return (List<User>) userDao.findAll();
	}

	@Override
	public User getUserByID(int id) {
		 
		return userDao.findOne(id);
	}
 
	@Override
	public List<User> getUsersByName(String name) {
		 
		return userDao.findUserByName(name);
	}

	@Override
	public int deleteUserById(int id) {
		 
		return userDao.deleteUserById(id);
	}

	 

	 

}
