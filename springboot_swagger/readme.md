# SpringBoot+JPA+Swagger

### 版本
  + spring boot 				 1.5.8.RELEASE
  + JDK 					     1.7+
  + Maven						 3+ 
### spring boot 
   + SpringMVC
   + AOP应用(自定义注解AOP)
   + 默认FastJson
   + spring-boot-starter-data-jpa
   + swagger
   + bootstrap
   
### 功能
- Spring boot 基本配置
- Spring boot 整合 Hibernate
- JSR-303 校验
>> @Query  
>> Query 使用
>> Example 使用
- REST接口测试    http://localhost:9090/swagger-ui.html
>> 自定义注解@MySwagger  指定 REST api
- Test 测试
>> Suite
- thymeleaf 使用

- druid 数据源添加
>> 添加druid 监控 
>>  1.添加@WebServlet  com.wym.springboot01.Controller.DruidStatViewServlet
>>  2.添加@WebFilter   com.wym.springboot01.Controller.DruidStatFilter
>>  3.@ServletComponentScan  扫描Servlet&Filter

'''
多数据源配置
https://www.cnblogs.com/tusheng/p/9077309.html
'''

 
