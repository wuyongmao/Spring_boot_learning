# SpringBoot+quartz+JPA

### 版本
  + spring boot 				 1.5.8.RELEASE
  + JDK 					     1.7+
  + Maven						 3+ 
### spring boot 
     + spring-boot-starter-data-jpa
     + spring-boot-starter-data-quartz
   
   
### 功能
- Spring boot 基本配置
- Spring boot 整合 Hibernate 
- 整合quartz

| |
|:-|  
|  // 1. 创建 SchedulerFactory   |
|  SchedulerFactory factory = new StdSchedulerFactory();   |
|  // 2. 从工厂中获取调度器实例   |
|  Scheduler scheduler = factory.getScheduler();   |
|  //scheduler = StdSchedulerFactory.getDefaultScheduler();   |
|  // 3. 引进作业程序   |
|  JobDetail jobDetail = JobBuilder.newJob(SampleJob.class).build();   |
|  // 4. 创建Trigger   |
|  Trigger trigger = TriggerBuilder.newTrigger().build() ;   |
|  // 5. 注册任务和定时器   |
|  scheduler.scheduleJob(jobDetail, trigger);   |
|  // 6. 启动 调度器     #Debug下可查看   |
|  scheduler.start();   |
  

 
