package com.wym.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Springboot07 {

	public static void main(String[] args) {
		SpringApplication.run(Springboot07.class, args);
	}
}
