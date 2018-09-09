package com.wym.springboot01.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wym.springboot01.bean.Customer;

public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {

}
