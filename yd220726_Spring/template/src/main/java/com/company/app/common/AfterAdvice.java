package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning = "ret")
	public void afterLog(JoinPoint jp, Object ret) {
		System.out.println("===============");
		System.out.println("[after] 로그 출력");
		System.out.println(ret);
	}
}
