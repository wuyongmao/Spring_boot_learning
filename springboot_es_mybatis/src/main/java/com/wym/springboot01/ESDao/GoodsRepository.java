package com.wym.springboot01.ESDao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.wym.springboot01.ESbean.GoodsInfo;

/**
 * 
 * @author yongmao.wu
 *
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {
}
