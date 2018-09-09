package com.wym.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wym.springboot01.ann.MySwagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
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
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(productApiInfo()).select()
				// 添加注解@MySwagger
				.apis(RequestHandlerSelectors.withClassAnnotation(MySwagger.class))
				// .apis(RequestHandlerSelectors.basePackage("com.wym.springboot01.Controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo productApiInfo() {

		return new ApiInfoBuilder().title("系统数据接口文档").description("Spring Boot相关文章请关注：https://github.com/wuyongmao")
				.termsOfServiceUrl("swagger-ui.html").contact("wuyongmao").version("1.0").build();
		/*
		 * ApiInfo apiInfo = new ApiInfo("系统数据接口文档", "文档描述 swagger接口", "1.0.0",
		 * " ", "741262164@qq.com", "license", "swagger-ui.html"); return
		 * apiInfo;
		 */
	}

}
