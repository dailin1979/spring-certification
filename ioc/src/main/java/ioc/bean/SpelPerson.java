package ioc.bean;

public class SpelPerson {
  private String name;
  private SpelCar car;

//  引用address bean中的city
  private String city;

//  根据car的price确定info, car的price超过30000为金领，否则为白领
  private String information;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SpelCar getCar() {
    return car;
  }

  public void setCar(SpelCar car) {
    this.car = car;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  @Override
  public String toString() {
    return "SpelPerson{" +
        "name='" + name + '\'' +
        ", car=" + car +
        ", city='" + city + '\'' +
        ", information='" + information + '\'' +
        '}';
  }
}
