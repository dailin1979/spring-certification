package com.ld.ioc.bean;

import java.util.List;

public class Family {
  private String name;
  private String address;
  private List<Car> cars;

  public Family(String name, String address, List<Car> cars) {
    this.name = name;
    this.address = address;
    this.cars = cars;
  }

  public Family() {
  }

  
}
