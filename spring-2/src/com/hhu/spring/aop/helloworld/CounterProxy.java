package com.hhu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
public class CounterProxy implements InvocationHandler{
    //要代理的对象
    private Counter target;

    public CounterProxy(Counter target) {
        this.target = target;
    }

    /**
     * 主要理解三个参数的含义
     * @param proxy：正在返回的代理对象，一般情况下在invoke方法中不使用该对象
     * @param method：正在被调用的方法
     * @param args：调用方法时传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //前置日志
        System.out.println("The method " + method.getName() + " begin with [" + args[0] + ", " + args[1] + "]");
        Object result = null;
        result = method.invoke(target,args);
        System.out.println("The method " + method.getName() + " end with " + result);
        return result;
    }
}
