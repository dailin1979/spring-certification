package ioc.bean.annotation.controller;

import ioc.bean.annotation.User;
import ioc.bean.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserControllerImpl implements UserController {

  private UserService userService;

  @Autowired
  public UserControllerImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void execute(User user) {
    System.out.println("user contoller execute...");
    userService.add(user);
  }
}
