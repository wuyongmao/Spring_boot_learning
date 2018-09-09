package com.wym.springboot01.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
	private final static Logger logger = LoggerFactory.getLogger(HelloAspect.class);
	
	@AfterReturning("@annotation(com.wym.springboot01.ann.MyInfoAnnotation)")
 	public void AfterReturning() {
		System.out.println("-@AfterReturning-------------------------@annotation(com.wym.springboot01.ann.MyInfoAnnotation)");
	}
	
	@Around("@within(org.springframework.web.bind.annotation.RestController) ") 
	public Object SimpleAOPParser(final ProceedingJoinPoint pjp) throws Throwable{
		try {
			Object [] args=pjp.getArgs();
			System.out.println("------args:"+Arrays.asList(args));
			Object o =pjp.proceed();
			 
			System.out.println("======retrue:"+o);
			return o;
		} catch (Throwable  e) {
			 throw e;
		}
		
	}
	@Before("@annotation(com.wym.springboot01.ann.MyInfoAnnotation)")
	public void BeforeAnn() {
		System.out.println("-@before-------------------------@annotation(com.wym.springboot01.ann.MyInfoAnnotation)");
	}
	
	
	

	@Pointcut("execution(public * com.wym.springboot01.Controller.UserController.getUser(..)) ")
	public void recordLog() {
		System.out.println(
				"-@Pointcut-------------------------execution(public * com.wym.springboot01.Controller.UserController.getUser(..)) ");

	}

	@After(value = "recordLog()")
	public void doAfter() {

		System.out.println("--recordLog()------------------doAfter--------------------------");
		logger.info("doAfter============== recordLog() ");
	}
 

	@Before(value = "execution(public * com.wym.springboot01.Controller.UserController.getUser(..)) ")
	public void doBefore() {

		System.out.println(
				"--------------------execution(public * com.wym.springboot01.Controller.UserController.getUser(..))--------------------------");
		logger.info("doBefore============== hello : ");
	}

	/*
	 * @After(value = "recordLog()") public void doAfter( ) {
	 * 
	 * System.out.println(
	 * "--recordLog()------------------doAfter--------------------------");
	 * logger.info("doBefore============== hello : " ); }
	 */
}
