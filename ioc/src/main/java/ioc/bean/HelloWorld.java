package ioc.bean;

public class HelloWorld {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("set name");
    this.name = name;
  }

  public HelloWorld() {
    System.out.println("init");
  }

  public void hello(){
    System.out.println("hello world: " + name);
  }
}
