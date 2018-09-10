//package com.wym.scheduler;
//
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.wym.job.SampleJob;
//
//@Configuration
//public class SampleScheduler {
//
//    @Bean
//    public JobDetail sampleJobDetail() {
//        return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
//                .usingJobData("name", "World") .storeDurably().build();
//    }
//
//    @Bean
//    public Trigger sampleJobTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(2).repeatForever();
//
//        return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
//                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
//    }
//}
