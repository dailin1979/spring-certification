package com.ld.spring.jdbc.example;

import com.ld.spring.jdbc.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeDao {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public EmployeeDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public EmployeeDao() {
  }

  public Employee getEmployeeById(Integer id){
    String sql = "select id, last_name as lastName, email, dept_id as \"department.id\" from employees where id = ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
    Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
    return employee;
  }
}
