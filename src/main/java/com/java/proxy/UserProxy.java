package com.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {

    //目标对象
    private Object target;

    public UserProxy(Object target) {
        this.target = target;
    }

    public Object createProxy(){
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader,interfaces,this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强方法
        System.out.println("日志打印。。");
        return method.invoke(target,args);
    }
}
