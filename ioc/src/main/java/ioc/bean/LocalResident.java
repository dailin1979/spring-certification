package ioc.bean;

import java.util.List;

public class LocalResident {
  private String name;
  private Address address;
  private List<Car> cars;

  @Override
  public String toString() {
    return "LocalResident{" +
        "name='" + name + '\'' +
        ", address=" + address +
        ", cars=" + cars +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }
}
