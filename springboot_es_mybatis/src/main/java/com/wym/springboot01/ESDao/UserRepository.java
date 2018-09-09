package com.wym.springboot01.ESDao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wym.springboot01.bean.User;

public interface UserRepository extends ElasticsearchRepository< User, Long> {

}