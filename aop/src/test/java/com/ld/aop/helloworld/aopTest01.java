package com.ld.aop.helloworld;

import com.ld.aop.impl.ArithmeticCalculator;
import com.ld.aop.impl.ArithmeticCalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest01 {

//  1. 创建spring 的ioc 容器

  ApplicationContext ctx;
  {
    ctx = new ClassPathXmlApplicationContext("application-context-aop.xml");
  }





  @Test
  public void test01(){

    //  2. 从ioc容器中获取bean的实例
    ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");

    //  3. 使用bean
    int result = arithmeticCalculator.add(1, 2);
    System.out.println("---> " + result);

    Integer divResult = arithmeticCalculator.div(6, 2);
    System.out.println("---> " + divResult);
  }

}
