package com.wym.springboot01;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestLambda {
	
	
	@Test
	public void foreachLambda(){
		String[] atp = {"atp1" ,"atp2"};  
			List<String> players =  Arrays.asList(atp);  
			  
			// 以前的循环方式  
//			for (String player : players) {  
//			     System.out.print(player + "; ");  
//			}  
			  
			// 使用 lambda 表达式以及函数操作(functional operation)  
//     		players.forEach(aa -> System.out.print(aa + "; "));  
			   
			// 在 Java 8 中使用双冒号操作符(double colon operator)  
//			players.forEach(System.out::println);
	}

}
