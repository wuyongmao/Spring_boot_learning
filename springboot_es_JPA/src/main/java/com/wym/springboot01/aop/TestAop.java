//package com.wym.springboot01.aop;
// 
//import java.text.SimpleDateFormat;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import com.wym.springboot01.ann.MyInfoAnnotation;
// 
// 
////描述切面类
//@Aspect
//@Component
//public class TestAop {
// 
//    /*
//     * 定义一个切入点
//     */
//    @Pointcut("@annotation(com.wym.springboot01.ann.MyInfoAnnotation)")
//    public void myInfoAnnotation() {
//    }
// 
// 
//    // 用@Pointcut来注解一个切入方法
//    @Pointcut("execution(* com.wym.springboot01.serviceimpl.UserServiceImpl.*.**(..))")
//    public void excudeController() {
//    	System.out.println("==========execution(* com.wym.springboot01.serviceimpl.UserServiceImpl.getUsers()==========================");
//    }
// 
//    /*
//     * 通过连接点切入
//     */
////    @Before("execution(* findById*(..)) &&" + "args(id,..)")
////    public void twiceAsOld1(Long id) {
////        System.out.println("切面before执行了。。。。id==" + id);
////
////    }
// 
// 
//    //@annotation 这个你应当知道指的是匹配注解
//    //括号中的 annotation 并不是指所有自定标签，而是指在你的注释实现类中 *Aspect 中对应注解对象的别名，所以别被俩 annotation  所迷惑。
//    @Around(value ="myInfoAnnotation()&&excudeController()&&@annotation(annotation)")
//    public Object twiceAsOld(ProceedingJoinPoint thisJoinPoint,
//                             MyInfoAnnotation annotation
//    ) {
//    	
//    	System.out.println("=========com.wym.springboot01.serviceimpl.UserServiceImpl.getUsers()===================");
//    	
//		return annotation.value();
//         
//        
//    }
//    
//
//	@After(value = "execution(public * com.wym.springboot01.Controller.UserController.getUser(..)) ")
//	public void doBefore(   ) {
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
//		System.out.println("--------------------@After--------------------------"+simpleDateFormat);
//	}
//    
//}