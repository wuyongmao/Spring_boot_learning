package com.wym.springboot01;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wym.springboot01.bean.Customer;
import com.wym.springboot01.bean.Order;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.dao.CustomerDao;
import com.wym.springboot01.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private CustomerDao customerDao;
    
    
    

    @Test
    public void testUserDao() {
        System.out.println("测试开始===userDao========"+userDao.count());
        User user =new User();
        user.setAge(28);
        user.setName("wuyongmao");
        user.setPwd("root");
		userDao.save(user );
        System.out.println("测试开始===userDao========"+userDao.count());
        


    }
    
    

    @Test
    public void testCustmerDao() {
        System.out.println("测试开始===customerDao========"+customerDao.count());
        Customer c=new Customer();
        c.setAddress("中山"); 
        c.setCname("宝元");
        Set<Order> orders =new HashSet<>();
        
        Order o1 =new Order();
        o1.setPname("手机");
        Order o2 =new Order();
        o2.setPname("平板");  
        orders.add(o1);
        orders.add(o2);
        
		c.setOrders(orders );
        
        customerDao.save(c);
        System.out.println("测试开始==customerDao========"+customerDao.count());
        


    }
    
}
 