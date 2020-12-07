package ioc.bean.factory;

import ioc.bean.Car;
import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法: 直接调用某个类的静态方法就可以返回Bean的实例
 */
public class StaticCarFactory {

  private static Map<String, Car> cars = new HashMap<>();

  static {
    cars.put("audi", new Car("audi", "q3", 30000));
    cars.put("vw", new Car("vw", "tiguan", 20000));
    cars.put("ford", new Car("ford", "focus", 10000));
  }

//  静态工厂方法
  public static Car getCar(String brand){
    return cars.get(brand);
  }

}
