package com.hhu.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.AjAttribute;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 日志切面,生命切面需要两个步骤：
 * 1.将切面放入到IOC容器中(这个是大前提)，这里可以用@Component注解
 * 2.再声明为一个切面
 * Created by WeiguoLiu on 2018/2/28.
 */
@Order(0)
@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* com.hhu.spring.aop.impl.*.*(int, int))")
    public void pointCut() {

    }

    //声明一个前置通知，在目标方法之前执行,
    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        //通过连接点JoinPoint可以获取方法名和参数
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The mothod " + methodName + " begins with[" + args.get(0) + ", " + args.get(1) + "]");
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("The method " + joinPoint.getSignature().getName() + " ends");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterRurning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " end with " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs Exception:" + ex);
    }

    /**
     * 环绕通知必须携带ProceedingJoinPoint对象，类似于动态代理的全过程，
     * 这个对象甚至可以决定是否执行目标方法，且环绕通知必须要有返回值，这个
     * 返回值也是目标方法的返回值
     *
     * @param pjp
     */
    @Around("execution(* com.hhu.spring.aop.impl.*.*(int, int))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //获取方法名
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        System.out.println("The method " + methodName + " begin with [" + args[0] + ", " + args[1] + "]");
        Object result = null;
        //执行目标方法,并获取返回值
        result = pjp.proceed();

        System.out.println("The method " + methodName + " end with " + result);
        return result;
    }
}
