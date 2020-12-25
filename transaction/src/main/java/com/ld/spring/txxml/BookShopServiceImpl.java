package com.ld.spring.txxml;

import com.ld.spring.txxml.service.BookShopDao;
import com.ld.spring.txxml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {


  private BookShopDao bookShopDao;

  public void setBookShopDao(BookShopDao bookShopDao) {
    this.bookShopDao = bookShopDao;
  }

  @Override
  public void perchase(String username, String isbn) {
//    1. 取得书的单价
    Integer price = bookShopDao.findBookPriceByIsbn(isbn);

//    2，更新书的库存
    bookShopDao.updateBookStockByIsbn(isbn);

//    更新用户余额
    bookShopDao.updateUserAccount(username,price);

  }
}
