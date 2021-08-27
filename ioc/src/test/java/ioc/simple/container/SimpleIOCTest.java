package ioc.simple.container;

import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

public class SimpleIOCTest {
    @Test
    public void testSimpleIOC() throws Exception {
        InputStream inputStream = SimpleIOC.class.getClassLoader().getResourceAsStream("ioc.xml");
        SimpleIOC bf = new SimpleIOC(inputStream);
        Car car = (Car) bf.getBean("car");
        System.out.println(car + " | " + car.getName());
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel + " | " + wheel.getBrand());
    }
}
