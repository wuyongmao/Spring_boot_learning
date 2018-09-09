package com.wym.springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication 
@MapperScan("com.wym.springboot01.dao")
public class Springboot08 {

	public static void main(String[] args) {
		SpringApplication.run(Springboot08.class, args);
	}
}
