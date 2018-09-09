package com.wym.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableTransactionManagement 
public class Springboot04Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot04Application.class, args);
	}
}
