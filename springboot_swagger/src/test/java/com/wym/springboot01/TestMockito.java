package com.wym.springboot01;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wym.springboot01.dao.UserDao;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMockito {
	
	@Mock//需要mock的bean
    private UserDao  userDao;

    @Before
    public void setUp() throws Exception {
        Mockito.when( userDao.count()).thenReturn((long) 1);
    }

    @Test
    public void test() {
        // 和上面的before 2选1
    	Mockito.when( userDao.count()).thenReturn((long) 2);
        System.out.println( "---- userDao.count()-----+"+userDao.count());
        

    }

}
