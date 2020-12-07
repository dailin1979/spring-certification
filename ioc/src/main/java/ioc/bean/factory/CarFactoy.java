package ioc.bean.factory;

import ioc.bean.Car;
import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法: 实例工厂的方法，即先需要创建工厂实例(singleton) 然后通过调用工厂的实例方法来返回bean的实例
 */
public class CarFactoy {
  private Map<String, Car> cars;

  public CarFactoy() {
    cars = new HashMap<>();
    cars.put("q3", new Car("audi", "q3", 30000, 269.9));
    cars.put("tiguan", new Car("vw", "tiguan", 20000, 240.0));
    cars.put("focus", new Car("ford", "focus", 10000, 200.0));
  }

  public Car getCar(String typ){
    return cars.get(typ);
  }
}
