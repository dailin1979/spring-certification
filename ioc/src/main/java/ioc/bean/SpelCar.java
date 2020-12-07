package ioc.bean;

public class SpelCar {

  private String brand;
  private Double price;
  private Double perimeterOfTyre;

  @Override
  public String toString() {
    return "SpelCar{" +
        "brand='" + brand + '\'' +
        ", price=" + price +
        ", perimeterOfTyre=" + perimeterOfTyre +
        '}';
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPerimeterOfTyre() {
    return perimeterOfTyre;
  }

  public void setPerimeterOfTyre(Double perimeterOfTyre) {
    this.perimeterOfTyre = perimeterOfTyre;
  }
}
