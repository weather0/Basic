package com.company.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdvice {
	@Around("LogAdvice.allpointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		Object ret = null;
		// 서비스 실행 전
		long start = System.currentTimeMillis();
		
		// 서비스 호출
		ret = pjp.proceed();
		
		// 서비스 실행 후
		long end = System.currentTimeMillis();
		System.out.println("경과시간: " + (end-start) + "ms");
		
		return ret;
	}

}
