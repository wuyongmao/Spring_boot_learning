package com.wym.springboot01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wym.springboot01.bean.User;
import com.wym.springboot01.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

// 	@MyInfoAnnotation
	@RequestMapping(value = "getuser/{id}", method = RequestMethod.POST)
	@ResponseBody
	public User getUser(@PathVariable int id) {
		System.out.println("--------");

		return userService.getUserByID(id);

	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public User addUser(User user) {
		try {
			if (userService.addUser(user) > 0) {
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

}
