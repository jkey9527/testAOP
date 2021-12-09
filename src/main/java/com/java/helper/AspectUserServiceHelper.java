package com.java.helper;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class AspectUserServiceHelper{
    public void before(){
        System.out.println("前置通知。。");
    }
    public void after(){
        System.out.println("后置通知。。");
    }
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("执行前通知。。");
        Object value = pj.proceed();
        System.out.println("执行后通知。。");
        return value;
    }
}
