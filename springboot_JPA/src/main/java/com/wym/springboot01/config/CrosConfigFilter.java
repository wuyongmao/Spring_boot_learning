package com.wym.springboot01.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
 * 全局CROS跨域， 或者Controller中添加
 * 
 * @CrossOrigin(origins = "http://172.16.0.59:8080", maxAge = 3600)
 * @author yongmaow
 */
@Configuration
public class CrosConfigFilter {
	@Bean
	public FilterRegistrationBean crosFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration cros = new CorsConfiguration();

		cros.setAllowCredentials(false);

		cros.addAllowedOrigin("*");

		cros.addAllowedHeader("*");

		cros.addAllowedMethod("*");

		source.registerCorsConfiguration("/**", cros);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

		bean.setOrder(0);

		return bean;
	}
}
