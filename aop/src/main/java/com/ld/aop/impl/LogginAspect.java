package com.ld.aop.impl;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面: 需要把这个类放入ioc容器，在声明为一个切面
@Aspect
@Component
public class LogginAspect {

// 声明该方法是前置通知，在目标方法开始之前执行
  @Before("execution(public Integer com.ld.aop.impl.ArithmeticCalculatorImpl.*(Integer, Integer))")
  public void beforeMethod(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    List<Object> args = Arrays.asList(joinPoint.getArgs());
    System.out.println("the method " + name + " begins with " + args);
  }
}
