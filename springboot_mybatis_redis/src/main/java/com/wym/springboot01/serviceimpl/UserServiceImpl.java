package com.wym.springboot01.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wym.springboot01.bean.User;
import com.wym.springboot01.dao.UserMapper;
import com.wym.springboot01.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional(propagation = Propagation.REQUIRED,
			isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	@Override
	public int addUser(User user) throws Exception  {
		int t = userMapper.insert(user);
		// 异常事务回滚
	//	int m = 1 / 0;
		return t;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(int id) {

		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<User> getUsers() {

		return userMapper.selectByExample(null);
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
