package com.ld.aop.dynamicProxy;

import com.ld.aop.impl.ArithmeticCalculator;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class ArithmeticCalculatorLoggingProxy {

// 被通知的对象， aop中的目标
  private ArithmeticCalculator target;

//  代理对象
  private ArithmeticCalculator proxy;

  public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
    this.target = target;
  }

  public ArithmeticCalculatorLoggingProxy() {
  }

  public ArithmeticCalculator getLoggingProxy(){
//    代理目标对象由哪个类加载器负责加载
    ClassLoader loader = target.getClass().getClassLoader();
//  代理对象的类型， 为了调用方法
    Class[] interfaces = new Class[]{ArithmeticCalculator.class};

//    当调用代理对象其中的方法值， 该执行的代码
    InvocationHandler handler = new InvocationHandler() {

      /**
       *
       * @param o 正在返回的哪个代理对象， 一般情况下，在invoke方法中不使用此对象
       * @param method 正在被调用的方法
       * @param objects 调用方法时传入的参数
       * @return
       * @throws Throwable
       */
      @Override
      public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = method.getName();
//        日志
        System.out.println("the method " + methodName + " begins with " + Arrays.asList(objects));

//        执行方法
        Object result = null;

        try {
//          在这里处理的advice是前置通知
          result = method.invoke(target, objects);
//          返回通知

        } catch (Exception e) {
          e.printStackTrace();
//          异常通知, 可以访问到方法抛出的异常
        }

//        后置通知， 因为方法可以抛出异常，访问不到方法的返回值

//        日志
        System.out.println("the method " + methodName + " end with " + result);
        return result;
      }
    };
    proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);

    return proxy;
  }
}
