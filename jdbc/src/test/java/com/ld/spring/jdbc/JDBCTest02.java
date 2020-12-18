package com.ld.spring.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest02 {

  private ApplicationContext ctx;
  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  {
    ctx = new ClassPathXmlApplicationContext("application-context.xml");
    jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
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
   * 类似于jdbcTemplate, 但是通过可以给参数起名字，避免了给?占位符对位置
   * 1. 好处: 如果有多个参数，不用对位置，直接对应参数名字，便于维护
   * 2. 缺点: 较为麻烦
   */
  @Test
  public void testUpdate(){
    String sql = "insert into employees(last_name, email, dept_id) values(:ln,:email,:deptId)";
    Map<String, Object> paraMap = new HashMap<>();
    paraMap.put("ln", "aaa");
    paraMap.put("email", "aaa@126.com");
    paraMap.put("deptId", 2);
    int updatedRows = namedParameterJdbcTemplate.update(sql, paraMap);
    System.out.println(updatedRows);
  }

  /**
   * update(String sql, SqlParameterSource paraSource)
   * 可以通过传递对象传递值，但是不能有级联属性
   * 1. sql语句中参数名字和类的属性一致!
   * 2. 使用 interface SqlParameterSource的实现类 new BeanPropertySqlParameterSource(employee);
   *
   */
  @Test
  public void testUpdate02(){
    String sql = "insert into employees(last_name, email, dept_id) values(:lastName,:email,:deptId)";

    Employee employee = new Employee();
    employee.setLastName("bbb");
    employee.setEmail("bbb@123.com");
    employee.setDeptId(1);

    SqlParameterSource paraSource = new BeanPropertySqlParameterSource(employee);
    int updatedRows = namedParameterJdbcTemplate.update(sql, paraSource);
    System.out.println(updatedRows);
  }


}
