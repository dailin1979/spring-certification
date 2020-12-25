package com.ld.spring.tx;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

  private BookShopService bookShopService;

  public CashierImpl() {
  }

  @Autowired
  public CashierImpl(BookShopService bookShopService) {
    this.bookShopService = bookShopService;
  }


  /*
   测试事务的传播属性， 可以通过tansactional的属性propagation定义
   默认值是propagation = Propagation.REQUIRED, 默认会在现有的事务内运行，其他的事务会挂起,即使用当前方法的事务.
   Supports -> 如果调用的事务方法有transaction,用存在, 没有就创建一个
   https://www.baeldung.com/spring-transactional-propagation-isolation
  */
  @Transactional(propagation = Propagation.SUPPORTS)
  @Override
  public void checkout(List<String> isbns, String username) {
    for (String isbn: isbns
    ) {
      bookShopService.perchase(username,isbn);
    }
  }
}
