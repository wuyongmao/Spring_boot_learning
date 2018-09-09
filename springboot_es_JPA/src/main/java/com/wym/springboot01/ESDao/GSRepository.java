package com.wym.springboot01.ESDao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wym.springboot01.ESbean.GoodsInfo;

public interface GSRepository extends ElasticsearchRepository< GoodsInfo, Long> {

}