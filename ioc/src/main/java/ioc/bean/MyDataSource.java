package ioc.bean;

import java.util.Properties;

public class MyDataSource {
  private Properties properties;

  public MyDataSource(Properties properties) {
    this.properties = properties;
  }

  public MyDataSource() {
  }

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "MyDataSource{" +
        "properties=" + properties +
        '}';
  }
}
