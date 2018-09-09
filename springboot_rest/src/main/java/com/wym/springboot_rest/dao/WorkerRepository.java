package com.wym.springboot_rest.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wym.springboot_rest.bean.Worker;
public interface WorkerRepository extends JpaRepository<Worker, Long> {
	 @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	    Worker findByNameStartsWith(@Param("name") String name);
}