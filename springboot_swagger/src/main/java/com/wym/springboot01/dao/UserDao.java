package com.wym.springboot01.dao;
 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wym.springboot01.bean.User;
//Repository --> CrudRepository--> PagingAndSortingRepository
public interface UserDao extends JpaRepository<User, Integer>{
//	@Query(value = "select * from user where name = :name",nativeQuery = true) 
//	@Query(value = "select * from user where name = ?1",nativeQuery = true) 
	List<User> findUserByName(@Param("name")String name);
	  
	
	
	@Modifying
	@Transactional
	@Query(value="delete from t_user   where id = ?1 ",nativeQuery = true)
	int deleteUserById(@Param("id") int id);
}
