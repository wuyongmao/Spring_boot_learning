package com.wym.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ServletComponentScan
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableTransactionManagement 
public class Springboot06Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot06Application.class, args);
	}
}
