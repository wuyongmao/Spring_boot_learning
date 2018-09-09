package com.wym.springboot01.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ann.MyInfoAnnotation;
import com.wym.springboot01.ann.MySwagger;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * User 操作
 * 
 * @author by wuyongmao on 2017/4/17.
 *         官方文档：http://swagger.io/docs/specification/api-host-and-base-path/
 */
@MySwagger
@RestController
public class UserController {

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-mm-dd hh:mm:ss"));
	}

	@Autowired
	UserService userService;

	@ApiOperation(value = "查询用户", notes = "根据url的id来查询对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Int", paramType = "path")
	@MyInfoAnnotation
	@RequestMapping(value = "getuser/{id}", method = RequestMethod.POST)
	public User getUser(@PathVariable int id) {

		System.out.println("------------");
		System.out.println(new Date());

		return userService.getUserByID(id);

	}

	@RequestMapping(value = "deluser/{id}", method = RequestMethod.POST)
	public void delUser(@PathVariable int id) {

		userService.deleteUser(id);

	}

	@RequestMapping(value = "deluserbyid/{id}", method = RequestMethod.POST)
	public int delUserByid(@PathVariable int id) {

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

	@RequestMapping(value = "adduserv", method = RequestMethod.POST)
	public User addUserv(@Validated User user, BindingResult result) {

		if (result.hasErrors()) {
			List<ObjectError> lErrors = result.getAllErrors();
			FieldError error = (FieldError) lErrors.get(0);
			System.out.println(error.getDefaultMessage() + "=----------" + error.getField());
			return null;
		} else {

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
}
