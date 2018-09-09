package com.wym.springboot01.webserviceimpl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wym.springboot01.service.UserService;
import com.wym.springboot01.webservice.UserWebservice;

@WebService(targetNamespace = "http://service.demo.example.com/", endpointInterface = "com.wym.springboot01.webservice.UserWebservice")
public class UserWebserviceimpl implements UserWebservice {

	@Autowired
	UserService userService;

	@Override
	public String getUserByid(int id) {
		ObjectMapper mapper = new ObjectMapper();

		String json="";
		try {
			json = mapper.writeValueAsString(userService.getUserByID(id));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);

		return json;
	}

}
