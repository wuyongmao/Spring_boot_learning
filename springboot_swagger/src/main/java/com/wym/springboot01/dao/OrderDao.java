package com.wym.springboot01.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wym.springboot01.bean.Order;

public interface OrderDao extends PagingAndSortingRepository<Order, Integer> {

}
