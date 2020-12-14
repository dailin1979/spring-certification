package com.ld.aop.impl;

import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
  @After("execution(public Integer com.ld.aop.impl.ArithmeticCalculator.*(Integer, Integer))")
  public void afterMethod(JoinPoint joinPoint){
    String name = joinPoint.getSignature().getName();
    System.out.println("the method " + name + " ends");
  }

//  返回通知

  /**
   * 在方法正常结束时，执行的代码
   * 返回通知时可以访问到方法的返回值的
   * @param joinPoint
   */
  @AfterReturning(value = "execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))",
  returning = "result")
  public void afterReturningMethod(JoinPoint joinPoint, Object result){
    String name = joinPoint.getSignature().getName();
    System.out.println("the method " + name + " ends with " + result);
  }

  /**
   * 在目标方法抛出异常时可以执行的代码
   * 可以访问到异常对象, 而且可以指定在抛出某个特定异常后执行通知代码
   * @param joinPoint
   * @param ex
   */
  @AfterThrowing(value = "execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))",
      throwing = "ex")
  public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
    String name = joinPoint.getSignature().getName();
    System.out.println("the method " + name + " occurs exception: " + ex);
  }

  // 这里只由在nullpointexception被抛出后，才会起作用
  @AfterThrowing(value = "execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))",
      throwing = "ex")
  public void afterThrowingMethod(JoinPoint joinPoint, NullPointerException ex){
    String name = joinPoint.getSignature().getName();
    System.out.println("the method " + name + " occurs exception: " + ex);
  }

  /**
   * 环绕通知一定要携带上ProceedingJoinPoint类型的对象作为参数
   * 环绕通知类似于动态代理的全过程， ProceedingJoinPoint对象可以决定是否执行目标方法
   * 被@Around注释的方法必须有返回值, 此返回值就是目标方法的返回值
   * @param proceedingJoinPoint
   */
 /* @Around(value = "execution(public * com.ld.aop.impl.ArithmeticCalculator.*(..))")
  public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){

    Object result = null;
    String methodName= proceedingJoinPoint.getSignature().getName();
    try {
//      前置通知
      System.out.println("The method " + methodName + " begins with " + Arrays.asList(proceedingJoinPoint.getArgs()));
      result= proceedingJoinPoint.proceed();
//    后置返回通知
      System.out.println("the method " + methodName + " ends with " + result);
    } catch (Throwable throwable) {
      System.out.println("this method " + methodName + " occurs exception: " + throwable);
      throwable.printStackTrace();
    }

//    后置通知
      System.out.println("the method " + methodName + " ends " );

    return result;*/
  }

}
