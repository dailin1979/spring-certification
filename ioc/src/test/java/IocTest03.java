

import ioc.bean.Address;
import ioc.bean.Car;
import ioc.bean.NewPerson;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest03 {

  private ApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("application-context-ioc-context.xml");
  }


  @Test
  public void test01() throws SQLException {
    DataSource dataSource = (DataSource) ctx.getBean("dataSource");
    System.out.println(dataSource.getConnection());
  }
}
