package com.wym.springboot01.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserWebservice {

	@WebMethod
	public String getUserByid(@WebParam(name = "id") int id);

}
