package com.ld.aop.validation;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面: 需要把这个类放入ioc容器，在声明为一个切面
@Order(1)
@Aspect
@Component
public class ValidationAspect {

//   声明该方法是前置通知，在某个interface每个实现类的目标方法开始之前执行一段代码
//  @Before("execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))")
//  如果在同一个package下，可以省略全类名的路径，直接使用类名.方法名()
  @Before("com.ld.aop.logging.LoggingAspect.delareJointPointExpression()")
  public void beforeMethod(JoinPoint joinPoint){
    System.out.println("---> validate: " + Arrays.asList(joinPoint.getArgs()));
  }

}
