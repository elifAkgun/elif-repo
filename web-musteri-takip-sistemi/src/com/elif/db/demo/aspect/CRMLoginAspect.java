package com.elif.db.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoginAspect {

	// setup loger
	private Logger logger = Logger.getLogger(getClass().getName());

	// setup pointcut expression
	@Pointcut("execution(* com.elif.db.demo.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.elif.db.demo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.elif.db.demo.service.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forGeneralFlow() {
	}

	// setup @Before advice
	@Before("forGeneralFlow()")
	public void before(JoinPoint joinPoint) {
		// display the which method calling
		logger.info("Before : " + joinPoint.getClass().getName() + " ----> " + joinPoint.getSignature().getName());

		Object[] args = joinPoint.getArgs();
		for (Object object : args) {
			logger.info("--> " + object);
		}

		// display the method arguments
	}

	// setup @AfterReturning advice
	@AfterReturning(pointcut = "forGeneralFlow()", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		// display the which method calling
		logger.info("After : " + joinPoint.getClass().getName() + " ----> " + joinPoint.getSignature().getName());

		logger.info("--> " + result);

		// display the method arguments
	}

}
