package ioc.bean.annotation.repository;

import ioc.bean.annotation.MyTestObject;
import ioc.bean.annotation.TestObject;
import ioc.bean.annotation.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserRepository implements UserRepository {

  private MyTestObject mto;


  public MyUserRepository( @Autowired(required = false) MyTestObject mto) {
    this.mto = mto;
  }

  @Override
  public void save(User user) {
    System.out.println("userrepository save...");
    System.out.println(user.toString());
    System.out.println(mto);
  }
}
