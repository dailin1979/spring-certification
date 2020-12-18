package com.ld.spring.jdbc;

public class Employee {
  private Integer id;
  private String lastName;
  private String email;
  private Integer deptId;

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
/*
为了测试NamedParameterJDBCTemplate,将级联属性改为dept_id
 */
//  public Department getDepartment() {
//    return department;
//  }
//
//  public void setDepartment(Department department) {
//    this.department = department;
//  }


  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", deptId=" + deptId +
        '}';
  }
}
