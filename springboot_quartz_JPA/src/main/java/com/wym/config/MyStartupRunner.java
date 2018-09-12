//package com.wym.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.wym.scheduler.CronSchedulerJob;
//
///**
// * 预先数据的加载
// * @author Administrator
// *
// */
//@Component
//public class MyStartupRunner implements CommandLineRunner {
//
//    @Autowired
//    public CronSchedulerJob scheduleJobs;
//
//    @Override
//    public void run(String... args) throws Exception {
//        scheduleJobs.scheduleJobs();
//        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
//    }
//}