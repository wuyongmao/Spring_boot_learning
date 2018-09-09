package com.wym.springboot01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.wym.springboot01.bean.Customer;
import com.wym.springboot01.bean.Order;
import com.wym.springboot01.bean.User;
import com.wym.springboot01.dao.BookDao;
import com.wym.springboot01.dao.CustomerDao;
import com.wym.springboot01.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTests {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	EntityManager em;
	
	
	/**
	 * Example 使用
	 */
	
	@Test
	public void teseExample(){
		 User user =new User();
		 user.setName("wuyan");
 		
		 ExampleMatcher matcher = ExampleMatcher.matching()
 		            .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
		            .withIgnorePaths("pwd");//忽略字段，即不管password是什么值都不加入查询条件
 		Example<User> example =Example.of(user, matcher);
		List<User> list=userDao.findAll(example, new Sort("id"));
		
		System.out.println( list.size());
	}
	

	/**
	 * JPA query测试(执行原生的SQL语句)
	 */
	@Test
	public void testCreateQuery() {

		Query query = em.createNativeQuery("SELECT COUNT(1),bname FROM t_book GROUP BY bname");
		List<Object[]> lObjects = query.getResultList();

		System.out.println(lObjects.size() + "------");

	}

	/**
	 * 查询结果非Entity 测试
	 */
	@Test
	public void testBookDao() {
		System.out.println("测试开始===testBookDao========" + bookDao.count());
		 

		List<Object[]> lb = bookDao.queryBookcount();
		if (lb != null)
			for (int i = 0; i < lb.size(); i++) {
				Object[] os = lb.get(i);
				System.out.println(os[0] + "----" + os[1]);
			}

		System.out.println("测试开始===testBookDao========" + bookDao.count());

	}

	@Test
	public void testUserDao() {
		System.out.println("测试开始===userDao========" + userDao.count());
		User user = new User();
		user.setAge(28);
		user.setName("wuyongmao");
		user.setPwd("root");
		userDao.save(user);
		System.out.println("测试开始===userDao========" + userDao.count());

	}

	/**
	 * 多表关联插入测试
	 */
	@Test
	public void testCustmerDao() {
		System.out.println("测试开始===customerDao========" + customerDao.count());
		Customer c = new Customer();
		c.setAddress("中山");
		c.setCname("宝元");
		Set<Order> orders = new HashSet<>();

		Order o1 = new Order();
		o1.setPname("手机");
		Order o2 = new Order();
		o2.setPname("平板");
		orders.add(o1);
		orders.add(o2);

		c.setOrders(orders);

		customerDao.save(c);
		System.out.println("测试开始==customerDao========" + customerDao.count());

	}

}
