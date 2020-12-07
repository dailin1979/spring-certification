

import ioc.bean.Address;
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

}
