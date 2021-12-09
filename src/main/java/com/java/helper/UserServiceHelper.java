package com.java.helper;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class UserServiceHelper implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("执行前通知。。");
        Object proceed = invocation.proceed();
        System.out.println("执行后通知。。");
        return proceed;
    }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知。。");
    }

    //增强方法：前置通知
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知。。");
    }

}
