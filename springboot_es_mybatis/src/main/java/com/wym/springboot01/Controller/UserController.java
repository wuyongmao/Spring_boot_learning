package com.wym.springboot01.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ESDao.UserRepository;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
 
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "getuser/{id}", method = RequestMethod.POST)
	public User getUser(@PathVariable int id) {

		return userService.getUserByID(id);

	}
	@RequestMapping(value = "getalluser", method = RequestMethod.GET)
	public List<User> getUser( ) {

		return userService.getUsers();

	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public User addUser(User user) {
		try {
			if (userService.addUser(user) > 0) {
				//添加ElasticSearch 索引
				userRepository.save(user);
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

}
