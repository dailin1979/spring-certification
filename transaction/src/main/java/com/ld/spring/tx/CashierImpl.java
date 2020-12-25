package com.ld.spring.tx;

import com.ld.spring.exception.BookStockException;
import com.ld.spring.exception.UserAccountException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
   1. 测试事务的传播属性， 可以通过tansactional的属性propagation定义
     默认值是propagation = Propagation.REQUIRED, 默认会在现有的事务内运行，其他的事务会挂起,即使用当前方法的事务.
     Supports -> 如果调用的事务方法有transaction,用存在, 没有就创建一个
     参见 https://www.baeldung.com/spring-transactional-propagation-isolation
   2. 使用isolation属性，指定transaction的隔离级别， 常用的是READ_COMMITTED
     参见 https://www.baeldung.com/spring-transactional-propagation-isolation
   3. 默认情况下，spring的transactionmanager对对所有运行时出现的异常进行rollback, 也可以通过 noRollbackFor 属性进行设置， 如
     noRollbackFor={UserAccountException.class, ...}
   4. 使用readOnly 属性指定此事务是否为只读， 表示这个事务只读取数据，但是不更新数据
   5. 使用timeout, 指定事务方法可以运行的时间， 超出了规定的时间，抛出timeoutexception, 事务回滚

  */
  @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, timeout = 2, readOnly = false,
      noRollbackFor = {BookStockException.class})
  @Override
  public void checkout(List<String> isbns, String username) {
    for (String isbn: isbns
    ) {
      bookShopService.perchase(username,isbn);
    }
  }
}
