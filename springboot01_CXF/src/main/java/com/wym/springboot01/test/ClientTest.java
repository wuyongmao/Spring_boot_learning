package com.wym.springboot01.test;
 
 
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
 
public class ClientTest {
 
	public static void main(String[] args) throws Exception {
 
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient("http://localhost:9090/soap/user?wsdl");
		Object[] objects = client.invoke("getUserByid", 1);
		System.out.println(objects[0].toString());
		
		
	}
 
}
