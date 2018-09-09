package com.wym.springboot01.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wym.springboot01.bean.User;
import com.wym.springboot01.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao() {
        System.out.println("测试开始==========="+userDao.count());
        User user =new User();
        user.setAge(28);
        user.setName("wuyongmao");
        user.setPwd("root");
		userDao.save(user );
        System.out.println("测试开始==========="+userDao.count());
        


    }
}
 