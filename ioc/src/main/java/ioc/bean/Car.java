package ioc.bean;

public class Car {

  private String brand;
  private String corp;
  private Integer price;
  private Double maxSpeed;

  public Car() {
  }

  public Car(String brand, String corp, Integer price) {
    this.brand = brand;
    this.corp = corp;
    this.price = price;
  }

  public Car(String brand, String corp, Double maxSpeed) {
    this.brand = brand;
    this.corp = corp;
    this.maxSpeed = maxSpeed;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getCorp() {
    return corp;
  }

  public void setCorp(String corp) {
    this.corp = corp;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(Double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  @Override
  public String toString() {
    return "Car{" +
        "brand='" + brand + '\'' +
        ", corp='" + corp + '\'' +
        ", price=" + price +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
