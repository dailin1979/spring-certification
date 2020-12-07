

import ioc.bean.Car;
import ioc.bean.SpelCar;
import ioc.bean.SpelPerson;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest04 {

  private ApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-spel.xml");
  }

  @Test
  public void test01(){
    SpelCar car = (SpelCar) ctx.getBean("car");
    System.out.println(car.toString());
  }

  @Test
  public void test02(){
    SpelPerson person = (SpelPerson) ctx.getBean("person");
    System.out.println(person.toString());
  }

}
