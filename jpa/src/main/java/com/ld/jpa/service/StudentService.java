package com.ld.jpa.service;

import com.ld.jpa.dao.StudentDao;
import com.ld.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

  @Autowired
  private StudentDao studentDao;

  @Transactional
  public void savePersons(Student stu1,Student stu2){
    studentDao.save(stu1);

//    int i = 10 / 0;
//
//    studentDao.save(stu2);
  }

  @Transactional
  public void savePersons(Student stu1){
    studentDao.save(stu1);
  }


}
