package ioc.bean;

public class NewPerson {
  private String name;
  private Integer age;
  private Address address;
  private Car car;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public NewPerson() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "NewPerson{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", address=" + address +
        ", car=" + car +
        '}';
  }
}
