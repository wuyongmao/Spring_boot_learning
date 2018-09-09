package com.wym.springboot01.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConcurrentMapCacheManager  缓存
 * @author Administrator
 *
 */
@Configuration
@ConditionalOnMissingBean(CacheManager.class)
public class SimpleCacheCofig   {
	@Bean 
	public ConcurrentMapCacheManager cacheManager(){
		return new ConcurrentMapCacheManager();
	}
 
	 
}