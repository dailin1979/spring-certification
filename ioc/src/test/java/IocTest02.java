

import ioc.bean.Address;
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

}
