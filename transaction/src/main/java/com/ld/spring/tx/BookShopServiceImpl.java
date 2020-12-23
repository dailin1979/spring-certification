package com.ld.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {


  private BookshopDao bookshopDao;

  @Autowired
  public BookShopServiceImpl(BookshopDao bookshopDao) {
    this.bookshopDao = bookshopDao;
  }

  public BookShopServiceImpl() {
  }

  @Override
  public void perchase(String username, String isbn) {
//    1. 取得书的单价
    Integer price = bookshopDao.findBookPriceByIsbn(isbn);

//    2，更新书的库存
    bookshopDao.updateBookStockByIsbn(isbn);

//    更新用户余额
    bookshopDao.updateUserAccount(username,price);

  }
}
