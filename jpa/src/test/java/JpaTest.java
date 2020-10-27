import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
  private ApplicationContext ctx = null;

  {
    ctx = new ClassPathXmlApplicationContext("META-INF/applicationcontext.xml");
  }

  @Test
  public void testDataSource() throws SQLException {
    DataSource source = ctx.getBean(DataSource.class);
    System.out.println(source.getConnection());
  }

}
