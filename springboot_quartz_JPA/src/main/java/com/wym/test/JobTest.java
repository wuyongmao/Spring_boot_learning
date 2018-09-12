package com.wym.test;

import java.util.Date;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wym.job.SampleJob;
import com.wym.job.ScheduledJob;

public class JobTest {
	Logger _log=LoggerFactory.getLogger(ScheduledJob.class); 
	 
	
	
	
	@Test
	public void quartzTest() throws SchedulerException{
	    // 1. 创建 SchedulerFactory
	    SchedulerFactory factory = new StdSchedulerFactory();
	    // 2. 从工厂中获取调度器实例
	    Scheduler scheduler = factory.getScheduler();
	      scheduler = StdSchedulerFactory.getDefaultScheduler();
	    
	    
	    // 3. 引进作业程序
	    JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)  .usingJobData("name", "World")
//	    		.withDescription("this is a ram job") //job的描述
//	            .withIdentity("jobTest", "jobTestGrip") //job 的name和group
	           
	            .build();
	
//	    long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
//	    Date statTime = new Date(time);
	
	    // 4. 创建Trigger
	    //使用SimpleScheduleBuilder或者CronScheduleBuilder
	    Trigger trigger = TriggerBuilder.newTrigger()
//	            .withDescription("this is a cronTrigger")
//	            .withIdentity("jobTrigger", "jobTriggerGroup")
//	            .withSchedule(SimpleScheduleBuilder.simpleSchedule()     )
	           // .startAt(statTime)  //默认当前时间启动
	            
 	            .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")) //两秒执行一次
	            .build() ;
	
	    // 5. 注册任务和定时器
	    scheduler.scheduleJob(jobDetail, trigger);
	
	    // 6. 启动 调度器     #Debug下可查看
	    scheduler.start();
	    _log.info("启动时间 ： " + new Date());
	      
	    
	}
}
