package com.wym.springboot01.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ann.MyInfoAnnotation;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@MyInfoAnnotation
	@RequestMapping(value = "getuser/{id}", method = RequestMethod.POST)
	public User getUser(@PathVariable int id) {

		return userService.getUserByID(id);

	}
	@RequestMapping(value = "deluser/{id}", method = RequestMethod.POST)
	public  void delUser(@PathVariable int id) {

		  userService.deleteUser(id);

	}
	
	@RequestMapping(value = "deluserbyid/{id}", method = RequestMethod.POST)
	public  int delUserByid(@PathVariable int id) {

		  return userService.deleteUserById(id);

	}
	
	
	@RequestMapping(value = "getalluser", method = RequestMethod.POST)
	public List<User> getAllUser() {

		return userService.getAllUsers();
	}

	
	@RequestMapping(value = "getuserbyname", method = RequestMethod.POST)
	public List<User> getUsersByName(String name) {

		return userService.getUsersByName(name);
	}
	
	
	
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public User addUser(User user) {

		try {
			User u = userService.addUser(user);
			if (u != null) {
				return u;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

}
