package com.wym.springboot01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wym.springboot01.ann.MySwagger;
import com.wym.springboot01.service.UserService;
@MySwagger
@Controller
public class User2Controller {

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-mm-dd hh:mm:ss"));
	}

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "getusers" )
	public String getAllUser(Model model) {
		model.addAttribute("hello", "Hello, Spring Boot!");
		model.addAttribute("userList", userService.getAllUsers());

		return "users";
	}

}
