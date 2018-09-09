package com.wym.springboot01.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wym.springboot01.webservice.UserWebservice;
import com.wym.springboot01.webserviceimpl.UserWebserviceimpl;

@EnableWebMvc
@Configuration
public class CxfWebConfig {
//	@Bean
//	public ServletRegistrationBean dispatcherServlet() {
//		return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
//
//	}

	@Bean
	// 一定要加，不然这个方法不会运行
	public ServletRegistrationBean getServletRegistrationBean() { // 一定要返回ServletRegistrationBean
		ServletRegistrationBean bean = new ServletRegistrationBean(
				new CXFServlet()); // 放入自己的Servlet对象实例
		bean.addUrlMappings("/soap/*"); // 访问路径值
		return bean;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public UserWebservice userWebService() {
		return new UserWebserviceimpl();
	}

	// 此处要注意导入正取的Endpoint、EndpointImpl包
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), userWebService());
		endpoint.publish("/user");
		return endpoint;
	}

}
