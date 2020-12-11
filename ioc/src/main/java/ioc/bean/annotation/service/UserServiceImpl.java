package ioc.bean.annotation.service;

import ioc.bean.annotation.User;
import ioc.bean.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl( @Qualifier("myUserRepository") UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void add(User user) {
    System.out.println("userServiceImpl add one user");
    userRepository.save(user);
  }
}
