

import ioc.bean.Car;
import ioc.bean.annotation.TestObject;
import ioc.bean.annotation.User;
import ioc.bean.annotation.controller.UserController;
import ioc.bean.annotation.repository.UserRepository;
import ioc.bean.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest07 {
//ConfigurableApplicationContext is ApplicationContext 子接口，通过这个子接口ioc容器可以使用close方法销毁bean
  private ConfigurableApplicationContext ctx = null;

  User user = new User();

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-annotation.xml");

  }

  @Test
  public void test01(){
    user.setId("10001");
    user.setUsername("tom");

//    TestObject to = (TestObject) ctx.getBean("testObject");
//    System.out.println(to);
//
//
//    UserService userService = (UserService) ctx.getBean("userService");
//    userService.add(user);

    UserController userController = (UserController) ctx.getBean("userController");
    userController.execute(user);

//    UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//    userRepository.save(user);
  }

}
