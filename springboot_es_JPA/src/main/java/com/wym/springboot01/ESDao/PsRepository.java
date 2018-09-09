package com.wym.springboot01.ESDao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wym.springboot01.ESbean.People;

public interface PsRepository extends ElasticsearchRepository< People, Long> {

}