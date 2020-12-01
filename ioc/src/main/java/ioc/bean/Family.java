package ioc.bean;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  @Override
  public String toString() {
    return "Family{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", cars=" + cars +
        '}';
  }
}
