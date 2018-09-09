package com.wym.springboot01.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	/* @Bean
	    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
	        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.configure(
	                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        objectMapper.getSerializerProvider().setNullValueSerializer(
	                new JsonSerializer<Object>() {
	                    @Override
	                    public void serialize(Object value, JsonGenerator jgen,
	                            SerializerProvider provider) throws IOException,
	                            JsonProcessingException {
	                        jgen.writeString("");
	                    }
	                });
	        // 进行HTML解码
	        objectMapper.registerModule(new SimpleModule().addSerializer(
	                String.class, new JsonSerializer<String>() {
	                    @Override
	                    public void serialize(String value, JsonGenerator jgen,
	                            SerializerProvider provider) throws IOException,
	                            JsonProcessingException {
//	                        jgen.writeString(StringEscapeUtils.(value));
	                    }
	                }));
	        jsonConverter.setObjectMapper(objectMapper);
	        return jsonConverter;
	    }

	    @Override
	    public void configureMessageConverters(
	            List<HttpMessageConverter<?>> converters) {
	        converters.add(customJackson2HttpMessageConverter());
	        super.addDefaultHttpMessageConverters(converters);
	    }*/

	    /**
	     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
	     * 
	     * @param registry
	     */
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations(
	                "classpath:/static/");
	        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
	                "classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations(
	                "classpath:/META-INF/resources/webjars/");
	        super.addResourceHandlers(registry);
	    }


	    /**
	     * 配置servlet处理
	     */
	    @Override
	    public void configureDefaultServletHandling(
	            DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }

	 @Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 1.需要先定义一个convert 转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2.添加fastJson的配置信息,比如，是否需要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		// 空值特别处理
		// WriteNullListAsEmpty 将Collection类型字段的字段空值输出为[]
		// WriteNullStringAsEmpty 将字符串类型字段的空值输出为空字符串 ""
		// WriteNullNumberAsZero 将数值类型字段的空值输出为0
		// WriteNullBooleanAsFalse 将Boolean类型字段的空值输出为false
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty);
		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		// 3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 4.将convert添加到converters当中
		converters.add(fastConverter);
	} 
}