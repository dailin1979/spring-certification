package ioc.bean.processors;

import ioc.bean.LifecycleCar;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
这个后置处理器是处理所有bean的,如果要特意处理一个bean的话加条件

 */
public class MyPostBeanProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    System.out.println("postProcessBeforeInitialization: " + o + ", " +  s);
    return o;
  }

  @Override
  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    System.out.println("postProcessAfterInitialization" + o + ", " +  s);
    LifecycleCar car = new LifecycleCar();
    if(o instanceof LifecycleCar){
      car.setBrand("bmw");
      o = car;
    }
    return o;
  }
}
