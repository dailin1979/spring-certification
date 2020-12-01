package ioc.bean;

import java.util.List;
import java.util.Map;

public class Company {
  private String name;
  private String address;
  private List<Car> cars;
  private Map<String,Car> parkedCar;


  public Company() {
  }

  public Company(String name, String address, List<Car> cars) {
    this.name = name;
    this.address = address;
    this.cars = cars;
  }

  public Company(String name, String address, List<Car> cars,
      Map<String, Car> parkedCar) {
    this.name = name;
    this.address = address;
    this.cars = cars;
    this.parkedCar = parkedCar;
  }

  public Map<String, Car> getParkedCar() {
    return parkedCar;
  }

  public void setParkedCar(Map<String, Car> parkedCar) {
    this.parkedCar = parkedCar;
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
    return "Company{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", cars=" + cars +
        ", parkedCar=" + parkedCar +
        '}';
  }
}
