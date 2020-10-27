

import com.ld.jpa.spring.entity.Student;
import com.ld.jpa.spring.service.StudentService;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTest {
  private ApplicationContext ctx = null;
  private StudentService studentService = null;

  {
    ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    studentService = ctx.getBean(StudentService.class);
  }

  @Test
  public void testDataSource() throws SQLException {
    DataSource source = ctx.getBean(DataSource.class);
    System.out.println(source.getConnection());

  }

  @Test
  public void testStudentService(){
    Student student01 = new Student();
    student01.setAge(20);
    student01.setEmail("aaa@123.com");
    student01.setLastName("aaa");

    System.out.println(studentService.getClass().getName());

    studentService.savePersons(student01);
  }

}
