

import ioc.bean.Car;
import ioc.bean.LifecycleCar;
import ioc.bean.SpelCar;
import ioc.bean.SpelPerson;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest05 {
//ConfigurableApplicationContext is ApplicationContext 子接口，通过这个子接口ioc容器可以使用close方法销毁bean
  private ConfigurableApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-lifecycle.xml");
  }

  @Test
  public void test01(){
    LifecycleCar car01 =  (LifecycleCar)ctx.getBean("car01");
    System.out.println(car01.toString());
    Car car02 = (Car)ctx.getBean("car02");
    System.out.println(car02.toString());
    ctx.close();
  }



}
