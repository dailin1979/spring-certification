package com.ld.aop.impl;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面: 需要把这个类放入ioc容器，在声明为一个切面
@Aspect
@Component
public class LogginAspect {

// 声明该方法是前置通知，在某个类的目标方法开始之前执行
//  @Before("execution(public Integer com.ld.aop.impl.ArithmeticCalculatorImpl.*(Integer, Integer))")
//  public void beforeMethod(JoinPoint joinPoint){
//    String name = joinPoint.getSignature().getName();
//    List<Object> args = Arrays.asList(joinPoint.getArgs());
//    System.out.println("the method " + name + " begins with " + args);
//  }

//   声明该方法是前置通知，在某个interface每个实现类的目标方法开始之前执行一段代码
  @Before("execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))")
  public void beforeMethod(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    List<Object> args = Arrays.asList(joinPoint.getArgs());
    System.out.println("the method " + name + " begins with " + args);
  }



//  后置通知， 在目标方法执行后(无论时候发生异常)都会执行的通知
//  在后置通知中，还不能访问目标方法返回的结果
  @After("execution(public Integer com.ld.aop.impl.ArithmeticCalculatorImpl.*(Integer, Integer))")
  public void afterMethod(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    System.out.println("the method " + name + " ends");
  }

}
