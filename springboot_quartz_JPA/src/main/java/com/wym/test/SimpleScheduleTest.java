package com.wym.test;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.wym.job.SampleJob;

//在测试的时候遇到一个问题，如果使用JUnit来进行测试的话，进程会死掉
public class SimpleScheduleTest {
	public static void main(String[] args) throws SchedulerException {
		//1.创建一个定时器对象
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		//2.定义一个工作对象
		JobDetail jobDetail = JobBuilder.newJob(SampleJob.class).withIdentity("job_1", "group1").build();

		//3.定义触发器SimpleScheduleBuilder
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_1", "group_1").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/8 * * * * ? *")).build();

		// 4. 注册任务和定时器
		scheduler.scheduleJob(jobDetail, trigger);

		// 开启定时任务
		scheduler.start();
	}
}