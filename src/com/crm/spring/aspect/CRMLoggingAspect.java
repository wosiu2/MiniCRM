package com.crm.spring.aspect;

import java.util.logging.Logger;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

	
	//setup Logger
	private Logger myLogger=
			Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//setup pointcut
	
	@Pointcut("execution(* com.crm.spring.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.crm.spring.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.crm.spring.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage()||forServicePackage()|| forDAOPackage()")
	private void forAppFlow() {}
	
	
	//Before
	@Before("forAppFlow()")
	public void before(JoinPoint jp) {
		

	String theMethod=jp.getSignature().toShortString();
		myLogger.info("in @Before: calling method:"+theMethod);
		
		for(Object e:jp.getArgs()) {
			myLogger.info("in @Before:arguments:"+e.toString());
		}
	}

	//AfterRet
	@AfterReturning(pointcut="forAppFlow()",
			returning="result")
	public void after(JoinPoint jPoint,Object result) {
		String theMethod=jPoint.getSignature().toShortString();
		myLogger.info("in @AfterReturning: calling method:"+theMethod);
		
		myLogger.info("result:"+result);
	}
}
