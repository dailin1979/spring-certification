package com.ld.hibernate.entity;

import static org.junit.Assert.*;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:application-context.xml")
public class HibernateSpringIntegrationTest {

  @Autowired
  DataSource dataSource;

  @Test
  public void testDataSource(){
    try {
      System.out.println(dataSource.getConnection());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

}