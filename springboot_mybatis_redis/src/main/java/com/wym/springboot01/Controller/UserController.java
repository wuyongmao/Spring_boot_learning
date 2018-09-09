package com.wym.springboot01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ann.MyInfoAnnotation;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.jedis.RedisUtil;
import com.wym.springboot01.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	RedisUtil redisUtil;

	@Cacheable(value = {"User" ,"tt"}, key = "'getuser'.concat('-').concat(#id)")
	@MyInfoAnnotation
	@RequestMapping(value = "getuser/{id}", method = RequestMethod.POST)
	public User getUser(@PathVariable int id) {
		User u = userService.getUserByID(id);
		System.out.println("--------" + redisUtil);

		// redisUtil.set("getuser", u);
		// u=(User)redisUtil.get("getuser");

		return u;

	}

	@CacheEvict(value = "User", key = "'getuser'.concat('-').concat(#id)") 
	@MyInfoAnnotation
	@RequestMapping(value = "deleteuser/{id}", method = RequestMethod.POST)
	public int deleteUser(@PathVariable int id) {
		int i = userService.deleteUser(id);
		// System.out.println("--------" + redisUtil);

		// redisUtil.set("getuser", u);
		// u=(User)redisUtil.get("getuser");

		return i;

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
