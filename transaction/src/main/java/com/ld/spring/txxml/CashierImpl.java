package com.ld.spring.txxml;

import com.ld.spring.txxml.service.BookShopService;
import com.ld.spring.txxml.service.Cashier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class CashierImpl implements Cashier {

  private BookShopService bookShopService;

  public void setBookShopService(BookShopService bookShopService) {
    this.bookShopService = bookShopService;
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
