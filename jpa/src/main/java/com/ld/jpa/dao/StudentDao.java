package com.ld.jpa.dao;

import com.ld.jpa.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

  //如何获取到和当前事务关联的 EntityManager 对象呢 ?
  //通过 @PersistenceContext 注解来标记成员变量!
  @PersistenceContext
  private EntityManager entityManager;

  public void save(Student student){
    entityManager.persist(student);
  }

}
