package com.ld.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest01 {

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

  /**
   * 从数据库中获取一条记录，实际上得到对应的一个对象
   * 通过RowMapper将一条记录和java object进行映射, 调用jdbcTemplate的queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
   * 1. rowMapper时指定如何映射结果集的行， 常用的实现类时BeanPropertyRowMapper
   * 2. 在sql中，实现数据库中的表中的列名和类中的属性名的映射，e.g. last_name as lastName
   * 3 jdbctemplate不能实现级联属性的映射， 需要orm支持，如hibernate
   *
   */
  @Test
  public void testQueryForObject(){
    String sql = "select id, last_name as lastName, email, dept_id as \"department.id\" from employees where id = ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
    Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
    System.out.println(employee);
  }


  /**
   * 不使用queryForList,而是query方法查询实体类的集合
   */
  @Test
  public void testQueryForList(){
    String sql = "select id, last_name as lastName, email, dept_id as \"department.id\" from employees where id > ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
    List<Employee> employeeList = jdbcTemplate.query(sql, rowMapper, 3);
    System.out.println(employeeList);
  }

  /**
   * 获取单列的值，或者做统计查询
   *
   */
  @Test
  public void testQueryForValueOfColumn(){
    String sql = "select count(id) from employees where dept_id = ?";
    Long count = jdbcTemplate.queryForObject(sql, Long.class, 3);
    System.out.println(count);
  }

}
