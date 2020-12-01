

import ioc.bean.Car;
import ioc.bean.HelloWorld;
import ioc.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

  private ApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc.xml");
  }

  @Test
  public void testIoc01(){
    HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    helloWorld.hello();
  }

  @Test
  public void testIoc02(){
    Car car = (Car) ctx.getBean("car2");
    System.out.println(car.toString());
  }

  @Test
  public void testIoc03(){
    Person person01= (Person) ctx.getBean("person01");
    System.out.println(person01.toString());
  }
}
