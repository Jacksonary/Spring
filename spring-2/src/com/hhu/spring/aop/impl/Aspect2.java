package com.hhu.spring.aop.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 第二个切面
 * Created by WeiguoLiu on 2018/2/28.
 */
@Aspect
@Component
public class Aspect2 {
    @Around("com.hhu.spring.aop.impl.LoggingAspect.pointCut()")
    public Object round(ProceedingJoinPoint pjp) throws Throwable {
        String menthodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        Object result = null;

        System.out.println("Aspect2:The method " + menthodName + " begin with[" +
        args[0] + "," + args[1] + "]");

        result = pjp.proceed();

        System.out.println("Aspect2: The method end with " + result);
        return result;
    }
}
