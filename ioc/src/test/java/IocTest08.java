

import ioc.bean.annotation.User;
import ioc.bean.annotation.controller.UserController;
import ioc.bean.generic.di.PersonService;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest08 {
//ConfigurableApplicationContext is ApplicationContext 子接口，通过这个子接口ioc容器可以使用close方法销毁bean
  private ConfigurableApplicationContext ctx = null;

  User user = new User();

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-generic-di.xml");

  }

  @Test
  public void test01() {
    PersonService personService = (PersonService) ctx.getBean("personService");
    personService.add();
  }

}
