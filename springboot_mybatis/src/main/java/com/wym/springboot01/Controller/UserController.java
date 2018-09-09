package com.wym.springboot01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ann.MyInfoAnnotation;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	
	
	@MyInfoAnnotation(value="-------------")
	@RequestMapping("getuser/{id}")
	public User getUser(@PathVariable int id) {

		return userService.getUserByID(id);

	}

}
