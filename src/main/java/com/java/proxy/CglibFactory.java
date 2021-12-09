package com.java.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibFactory implements MethodInterceptor {
    //代理对象
    private Object target;
    public CglibFactory(Object target) {
        this.target = target;
    }
    //创建代理对象方法
    public Object createProxy(){
        //enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置代理对象的class
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        //返回代理对象
        return enhancer.create();
    }
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("记录日志。。");
        return method.invoke(target,args);
    }
}
