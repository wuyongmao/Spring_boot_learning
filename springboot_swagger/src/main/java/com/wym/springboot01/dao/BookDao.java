package com.wym.springboot01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wym.springboot01.bean.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	
	/**
	 * 查询结果非 Entity  返回Object 数组
	 * @return
	 */
	@Query(value= "select count(1),bname from t_book group by bname ",nativeQuery=true)
	public List<Object []> queryBookcount();

}
