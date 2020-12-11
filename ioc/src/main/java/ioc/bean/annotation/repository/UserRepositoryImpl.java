package ioc.bean.annotation.repository;

import ioc.bean.annotation.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

  @Override
  public void save(User user) {
    System.out.println("userrepository save...");
    System.out.println(user.toString());
  }
}
