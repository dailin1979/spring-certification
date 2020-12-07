package ioc.bean;

public class LifecycleCar {
  private String brand;

  public LifecycleCar() {
    System.out.println("LifecycleCar's constructor");
  }

  public void setBrand(String brand) {
    System.out.println("setter is called");
    this.brand = brand;
  }

  public void initBean(){
    System.out.println("init bean");
  }

  public void destroyBean(){
    System.out.println("destroy bean ...");
  }

  @Override
  public String toString() {
    return "LifecycleCar{" +
        "brand='" + brand + '\'' +
        '}';
  }
}
