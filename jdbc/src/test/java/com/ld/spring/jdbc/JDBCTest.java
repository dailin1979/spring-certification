package com.ld.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTest {

  private ApplicationContext ctx;
  private JdbcTemplate jdbcTemplate;

  {
    ctx = new ClassPathXmlApplicationContext("application-context.xml");
    jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
  }

  @Test
  public void testDataSource(){
    DataSource dataSource = (DataSource) ctx.getBean("dataSource");
    try {
      System.out.println(dataSource.getConnection());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  /**
   * 执行instert, update, delete
   */
  @Test
  public void testUpdate(){
    String sql = "update employees set last_name = ? where id = ?";
    int updatedRecord = jdbcTemplate.update(sql, "Jack", 4);
    System.out.println(updatedRecord);
  }

  /**
   * 执行批量update,inster or delete
   * bachUpdate方法的最后一个参数时object[]的List类型, 因为修改一个记录需要一个object的数组， 多条的话就成为了List<Object[]>
   */
  @Test
  public void testBatchUpdate(){
    String sql = "insert into employees(last_name, email, dept_id) values(?,?,?)";
    List<Object[]> batchArgs = new ArrayList<>();
    batchArgs.add(new Object[]{"AAA", "aaa@123.com", 3});
    batchArgs.add(new Object[]{"BBB", "bbb@123.com", 3});
    batchArgs.add(new Object[]{"CCC", "ccc@123.com", 3});
    batchArgs.add(new Object[]{"DDD", "ddd@123.com", 3});
    int[] batchUpdated = jdbcTemplate.batchUpdate(sql, batchArgs);
    System.out.println(batchUpdated.length);
  }

}
