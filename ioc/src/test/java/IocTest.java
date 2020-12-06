

import ioc.bean.Car;
import ioc.bean.Company;
import ioc.bean.HelloWorld;
import ioc.bean.LocalResident;
import ioc.bean.MyDataSource;
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

  @Test
  public void testIoc04(){
    Company company001 = (Company) ctx.getBean("company001");
    System.out.println(company001.toString());
  }

  @Test
  public void testIoc05(){
    Company company002 = (Company) ctx.getBean("company002");
    System.out.println(company002.toString());
  }

  @Test
  public void testIoc06(){
    MyDataSource myDataSource = (MyDataSource) ctx.getBean("dataSource");
    System.out.println(myDataSource.toString());
  }

  @Test
  public void testIoc07(){
    Company company003 = (Company) ctx.getBean("company003");
    System.out.println(company003.toString());
  }

  @Test
  public void testIoc08(){
    Person person02= (Person) ctx.getBean("person02");
    System.out.println(person02.toString());
  }

  @Test
  public void testIoc09(){
    LocalResident localResident01 = (LocalResident) ctx.getBean("localResident01");
    System.out.println(localResident01.toString());
  }
}
