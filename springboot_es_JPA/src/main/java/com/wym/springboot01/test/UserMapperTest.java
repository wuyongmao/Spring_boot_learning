//package com.wym.springboot01.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.wym.springboot01.bean.User;
//import com.wym.springboot01.dao.UserMapper;
//import com.wym.springboot01.service.UserService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserMapperTest {
//
//    @Autowired
//    private UserMapper UserMapper;
//    
//    @Autowired
//    private UserService userService;
//
//    //@Test
//    public void testselectByPrimaryKey() throws Exception {
//    	  
//    	System.out.println(UserMapper.selectByPrimaryKey(1) );
//    }
//
//     @Test
//    public void testgetUsers() throws Exception {
//    	  
//    	System.out.println("---------------------" );
//    	System.out.println(userService.getUsers().size() );
//    }
//    
//    @Test
//    public void testaddUser() throws Exception {
//    	User user =new User();
//    	user.setAge(18);
//    	user.setName("陈俊");
//    	user.setPwd("root"); 
//    	System.out.println("-------insert user--------------" );
//    	try {
//    		System.out.println(userService.addUser(user) );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	
//    }
//
//}
//
