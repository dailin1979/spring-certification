package com.ld.hibernate.service.iml;

import com.ld.hibernate.service.BookShopService;
import com.ld.hibernate.service.Cashier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cashier")
public class CashierImpl implements Cashier {

  private BookShopService bookShopService;

  public CashierImpl() {
  }

  @Autowired
  public CashierImpl(BookShopService bookShopService) {
    this.bookShopService = bookShopService;
  }

  @Override
  public void checkout(List<String> isbns, String username) {
    for (String isbn: isbns
    ) {
      bookShopService.perchase(username,isbn);

    }
  }
}
