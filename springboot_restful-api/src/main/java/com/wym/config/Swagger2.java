package com.wym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wuyongmao
 * @version 1.0.0
 * @date 2018-09-03
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(productApiInfo())
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.wym.restApiController"))
				.paths(PathSelectors.any()).build();
////    .paths(or(regex("/wym/.*")))//过滤的接口

	}

	private ApiInfo productApiInfo() {

		ApiInfo apiInfo = new ApiInfo("系统数据接口文档", "文档描述 swagger接口", "1.0.0",
				" ", new Contact("wuyongmao", "741262164@qq.com",
						"741262164@qq.com"), "license", "swagger-ui.html");

		return apiInfo;
	}

}
