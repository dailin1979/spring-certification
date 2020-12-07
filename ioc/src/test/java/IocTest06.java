

import ioc.bean.Car;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest06 {
//ConfigurableApplicationContext is ApplicationContext 子接口，通过这个子接口ioc容器可以使用close方法销毁bean
  private ConfigurableApplicationContext ctx = null;
  Car car;

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-factory.xml");

  }

  /*
  测试静态工厂方法
   */
  @Test
  public void test01(){
    car = (Car) ctx.getBean("car01");
    System.out.println(car.toString());
  }

  /*
  测试实例工厂方法
   */
  @Test
  public void test02(){
    car = (Car) ctx.getBean("car02");
    System.out.println(car.toString());
  }

  /*
  测试自定义的FactoryBean接口
 */
  @Test
  public void test03(){
    car = (Car) ctx.getBean("car03");
    System.out.println(car.toString());
  }
}
