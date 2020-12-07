package ioc.bean.factory;

import ioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义的FactoryBean， 需要实现FactoryBean interface
 */
public class CarFactoryBean implements FactoryBean<Car> {

  private String brand;
  private String typ;
  private Integer price;
  private Double maxSpeed;

  public void setBrand(String brand){
    this.brand = brand;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setMaxSpeed(Double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  /**
   * 返回Bean的对象
   * @return
   * @throws Exception
   */
  @Override
  public Car getObject() throws Exception {
    return new Car(this.brand, this.typ, this.price, this.maxSpeed);
  }

  /**
   * 返回bean的类型
   * @return
   */
  @Override
  public Class<?> getObjectType() {
    return null;
  }

  /**
   * 是否是单例
   * @return
   */
  @Override
  public boolean isSingleton() {
    return true;
  }
}
