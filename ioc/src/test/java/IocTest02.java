

import ioc.bean.Address;
import ioc.bean.Car;
import ioc.bean.NewPerson;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest02 {

  private ApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("application-contest-ioc-bean-relationship.xml");
  }

//  bean 的配置继承
  @Test
  public void test01(){
    Address address01, address02;
    address01 = (Address) ctx.getBean("address01");
    address02 = (Address) ctx.getBean("address02");
    System.out.println(address01.toString());
    System.out.println(address02.toString());
  }

  //  bean 的依赖
  @Test
  public void test02(){
    NewPerson myPerson01;
    myPerson01 = (NewPerson) ctx.getBean("person01");
    System.out.println(myPerson01.toString());
  }

  //  bean 的作用域, 默认的是singelton, 可以通过scope属性改变为prototype，这样的话每次调用getbean返回的是不同的实例
  @Test
  public void test03(){
    NewPerson myPerson01, myPerson02;
    myPerson01 = (NewPerson) ctx.getBean("person01");
    myPerson02 = (NewPerson) ctx.getBean("person01");

    System.out.println(myPerson01.equals(myPerson02));

    Car car01, car02;
    car01= (Car) ctx.getBean("car02");
    car02= (Car) ctx.getBean("car02");
    System.out.println(car01.equals(car02));
  }

}
