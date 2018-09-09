# SpringBoot + ElasticSearch 

### 版本 
  + spring boot 				 1.5.8.RELEASE
  + JDK 					     1.7+
  + Maven						 3+ 
  + ElasticSearch                [2.4.6](https://www.elastic.co/downloads/past-releases/elasticsearch-2-4-6)
### spring boot 
   + SpringMVC
   + AOP应用(自定义注解AOP) 
   + spring-boot-starter-data-elasticsearch
      + spring.data.elasticsearch.cluster-nodes = 127.0.0.1:9300
      
    
### 功能
	- Spring boot 基本配置
	- Spring boot 整合 ElasticSearch
	- springboot 对应ElasticSearch 版本
SpringBoot Version(x) | Spring-Data Elasticsearch Version(y) | Elasticsearch Version(z)
-|-|-
x <= 1.3.5 | y <= 1.3.4 | z <= 1.7.2*
x >= 1.4.x | 2.0.0 <=y < 5.0.0** | 2.0.0 <= z < 5.0.0**
   
