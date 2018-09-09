package com.wym.springboot01.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wym.springboot01.ESDao.PsRepository;
import com.wym.springboot01.ESbean.People;

/**
 * 
 * @author yongmao.wu
 *
 */
@RestController
public class PsController {

	@Autowired
	private PsRepository PsRepository;

	// http://localhost:8888/savepl
	@GetMapping("savepl")
	public People save() {
		
		People ps=new People(  System.currentTimeMillis(), "wuyongmao");
		ps=PsRepository.save(ps);
		return ps;
	} 
	@GetMapping("getps")
	public Iterable<People> getps() {
		  
		return   PsRepository.findAll();
	} 
	
	
	
}
